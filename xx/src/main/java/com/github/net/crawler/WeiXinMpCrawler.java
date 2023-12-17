package com.github.net.crawler;

import com.xiaoleilu.hutool.lang.Assert;
import com.xiaoleilu.hutool.util.StrUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;


public class WeiXinMpCrawler {

    public static void main(String[] args) throws Exception {

        // 获取该网页的url地址
        String url = "https://mp.weixin.qq.com/s/f68Hh40y-yfslpm3LASNFQ";
        // 解析成文档对象
        Document document = Jsoup.parse(new URL(url), 10000);

        System.out.println("标题：" + document.getElementById("activity-name").html());
        System.out.println("作者：" + document.getElementById("js_name").html());
        System.out.println("发布时间" + getPublishTime(document));
//        Element timeElement = document.select(".publish_time").first();
//        String time = timeElement.text();
        String script = document.getElementsByTag("script").toString();
        int index = script.indexOf("var createTime");
        System.out.println(script.substring(index + 18, index + 28));

        String date = document.select("em#post-date").text();
        System.out.println(date);

        document.select("div#js_content div.qq_map").remove();//删除地图

        document.select("div#js_content #js_pay_area").remove();//删除付费区域

        document.select("div#js_content #js_sg_bar").remove();//删除分享栏

        document.select("div#js_content .qr_code_pc_outer").remove();//删除二维码

        document.select("div#js_content #js_toobar3").remove();//删除推荐栏


        // 获取到父节点id为js_content的所有元素
        Element jsContent = document.getElementById("js_content");
//        System.out.println("详情" + jsContent);

        System.out.println("\n");
        Elements allElements = jsContent.getAllElements();
        for (Element e : allElements) {
            System.out.println(e);
        }
        // 获取到标签为img的素有元素集合
//        System.out.println(jsContent.html());
//        Elements imgs = jsContent.getElementsByTag("img");
//        int id = 0;
//        for (Element img : imgs) {
//            //获取图片的url地址
//            String attr = img.attr("data-src");
//            // 获取输入流
//            URL target = new URL(attr);
//            URLConnection urlConnection = target.openConnection();
//            // 获取输入流
//            InputStream inputStream = urlConnection.getInputStream();
//            id++;
//            FileOutputStream fileOutputStream = new FileOutputStream("/Users/chenjw/tmp/jsoup/" + id + ".jpg");
//            int temp = 0;
//            while ((temp=inputStream.read())!=-1){
//                fileOutputStream.write(temp);
//            }
//            System.out.println(id + ".jpg下载完毕");
//            fileOutputStream.close();
//            inputStream.close();
//
//        }

    }


    /**
     * 从html 内容中获取文章发文时间
     *
     * @param document html 文档对象 （该文章的所有html对象）
     * @return
     */
    public static String getPublishTime(Document document) {
        Elements scripts = document.select("script");
        for (Element script : scripts) {
            String html = script.html();

            // 需要获取的节点
            if (html.contains("document.getElementById(\"publish_time\")")) {
                int fromIndex = html.indexOf("s=\"");

                // StrUtil 工具为 hutool.cn工具
                return StrUtil.sub(html, fromIndex + 3, 10);
//                return html;
            }
        }
        return null;
    }

    /**
     * 从html 内容中获取公众号的标题
     *
     * @param document html 文档对象
     * @return
     */
    public static String getTitle(Document document) {
        Elements titles = document.getElementsByClass("rich_media_title");
        return StrUtil.trim(titles.get(0).text());
    }

    /**
     * 从html 内容中获取公众号的封面图
     *
     * @param document html 文档对象
     * @return
     */
    public static String getTitleImage(Document document) {
        Elements metas = document.getElementsByAttributeValue("property", "og:image");
        Element element = metas.get(0);
        if (element == null) {
            return "";
        }
        String content = element.attr("content");
        return StrUtil.trim(content);
    }

    /**
     * 从html 内容中获取文章的作者
     *
     * @param document html 文档对象
     * @return
     */
    public static String getWeChatName(Document document) {
        Element author = document.getElementById("js_name");
        Assert.notNull(author, "查找不到文章公众号，请输入合法的公众号文章连接");
        return StrUtil.trim(author.text());
    }

    /**
     * 从html 内容中获取文章公众号
     *
     * @param document html 文档对象
     * @return
     */
    public static String getWeChatAccount(Document document) {
        Elements metaValues = document.getElementsByClass("profile_meta_value");
        Assert.notEmpty(metaValues, "查找不到文章公众号，请输入合法的公众号文章连接");
        String text = metaValues.get(0).text();
        Assert.notBlank(text, "查找不到文章公众号，请输入合法的公众号文章连接");
        return StrUtil.trim(text);
    }
}
