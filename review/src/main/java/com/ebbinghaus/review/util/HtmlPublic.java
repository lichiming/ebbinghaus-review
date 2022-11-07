package com.ebbinghaus.review.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HtmlPublic {

    public static String url;



    private static String getUrl() {
        if (url == null) {

            if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
                url = "/Users/lichiming/Desktop/html/mainpage.html";
            } else {
                url = "D:\\nginx-1.21.6\\html\\mainpage.html";
            }
        }

        return url;
    }

    public static void createHtmlFile(List<String> mapHtmlString) {

        // 待处理的流
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        FileOutputStream fos;
        try {
            File file = new File(getUrl());

            //如果路径(无论多少层路径)不存在
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fos = new FileOutputStream(file);

            PrintWriter pw = new PrintWriter(fos);

            for (String lineStr : mapHtmlString) {
                pw.println(lineStr);
            }
            pw.close();
            bao.writeTo(fos);
            fos.flush();
            fos.close();
            bao.flush();
            bao.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public static String getMapHtmlFirstString() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>艾宾浩斯记忆遗忘曲线复习器</title>\n" +
                "\t<script type=\"text/javascript\" src=\"./jquery-3.6.0.min.js\"></script>\n" +
                "\n" +
                "\t<script type=\"text/javascript\">\n" +
                "\n" +
                "\t\tfunction refreshTd(){\n" +
                "\t\t\t$('#mainBody tr').each(function(i){                   // 遍历 tr\n" +
                "\t\t\tvar searchTarget= $(this).children(\"td\").class.eq(\"11-7\");\n" +
                "\t\t\t\tif(searchTarget.search(searchContent)!=-1){\n" +
                "\t\t\t\t\t$(this).css({\n" +
                "\t\t\t\t\t\t\"background-color\":\"red\"\n" +
                "\t\t\t\t\t});\n" +
                "\t\t\t\t}else{\n" +
                "\t\t\t\t\t$(this).css({\n" +
                "\t\t\t\t\t\t\"background-color\":\"white\"\n" +
                "\t\t\t\t\t});\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t});\n" +
                "\t\t\t}\n" +
                "\t\t\t"+
                "\n\t\t\tfunction deleteCell(value){\n" +
                "\t\t\t\t$.ajax({\n" +
                "\t\t\t\t\ttype:'post',\n" +
                "\t\t\t\t\turl:'http://127.0.0.1:8852/html/deleteCell',\n" +
                "\t\t\t\t\tdata:JSON.stringify({\n" +
                "\t\t\t\t\t\t\"content\": value\n" +
                "\t\t\t\t\t}),\n" +
                "\t\t\t\t\tcontentType: \"application/json\",\n" +
                "\t\t\t\t\tsuccess: function (data) {\n" +
                "\t\t\t\t\t\tlocation.reload();\n" +
                "\t\t\t\t\t\t}\t\n" +
                "\t\t\t\t});" +
                "\t\t\t}" +
                "\n\t\t$(document).ready(function(){\n" +
                "$.ajax({\n" +
                "\t\t\t\t\ttype:'post',\n" +
                "\t\t\t\t\turl:'http://127.0.0.1:8852/html/getData',\n" +
                "\t\t\t\t\tdata:JSON.stringify({\n" +
                "\t\t\t\t\t\t\"content\": 1\n" +
                "\t\t\t\t\t}),\n" +
                "\t\t\t\t\tcontentType: \"application/json\",\n" +
                "\t\t\t\t\tsuccess: function (data) {\n" +
                "\t\t\t\t\t\t\t$(\".\"+data).css({\n" +
                "\t\t\t\t\t\t\t\t\"background-color\":\"red\"\n" +
                "\t\t\t\t\t\t\t});\n" +
                "\t\t\t\t\t\t}\t\n" +
                "\t\t\t\t});"+
                "            $(\"#refresh\").click(function(){\n" +
                "                refresh();\n" +
                "            });\n" +
                "\t\t\t\n" +
                "\n" +
                "\t\t\t$(\"#contentButton\").click(function(){\n" +
                "\t\t\t\n" +
                "\t\t\t\tvar content = $(\"#contentInput\").val();\n" +
                "\n" +
                "\t\t\t\t$.ajax({\n" +
                "\t\t\t\t\ttype:'post',\n" +
                "\t\t\t\t\turl:'http://127.0.0.1:8852/html/add',\n" +
                "\t\t\t\t\tdata:JSON.stringify({\n" +
                "\t\t\t\t\t\t\"content\": content\n" +
                "\t\t\t\t\t}),\n" +
                "\t\t\t\t\tcontentType: \"application/json\",\n" +
                "\t\t\t\t\tsuccess: function (data) {\n" +
                "\t\t\t\t\t\tlocation.reload();\n" +
                "\t\t\t\t\t\t}\t\n" +
                "\t\t\t\t});\n" +
                "\t\t\t});\t\n" +
                "\n" +
                "\n" +
                "            \n" +
                "              \n" +
                "\t\t});\n" +
                "\t</script>\n" +
                "    <style>\n" +
                "\t\ttable tr td{\n" +
                "\t\t\tbackground: #cde8e5\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "学习简要：<input id = \"contentInput\" size=\"25\"/>\n" +
                "<button type=\"button\" id=\"contentButton\" >新增任务</button>&nbsp; &nbsp; &nbsp; &nbsp;<br><br><br><br>\n" +
                "<table  id=\"mainBody\">";

    }

    public static String getMapHtmlLastString() {
        return "</table>\n" +
                "</body>\n" +
                "</html>\n";
    }

    public static ArrayList<String> readLine() {
        FileInputStream fis = null;

        InputStreamReader isr = null;

        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。

        ArrayList<String> returnList = new ArrayList<>();
        try {

            String str = "";

            String str1 = "";

            fis = new FileInputStream(getUrl());// FileInputStream

            // 从文件系统中的某个文件中获取字节

            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,

            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象

            int flag = 0;
            while ((str = br.readLine()) != null) {
                if (str.contains("</table>")) {
                    flag = 0;
                }
                if (flag == 1) {
                    returnList.add(str);
                }
                if (str.contains("<tr><td>学习内容</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>删除</td></tr>")) {
                    flag = 1;
                }



            }

            // 当读取的一行不为空时,把读到的str的值赋给str1

            System.out.println(str1);// 打印出str1

        } catch (FileNotFoundException e) {

            System.out.println("找不到指定文件");

        } catch (IOException e) {

            System.out.println("读取文件失败");

        } finally {

            try {

                br.close();

                isr.close();

                fis.close();

// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
        return returnList;
    }







    public static ArrayList<String> deleteLine(String delete) {
        FileInputStream fis = null;

        InputStreamReader isr = null;

        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。

        ArrayList<String> returnList = new ArrayList<>();
        try {

            String str = "";

            String str1 = "";

            fis = new FileInputStream(getUrl());// FileInputStream

            // 从文件系统中的某个文件中获取字节

            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,

            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象

            while ((str = br.readLine()) != null) {
                if (!str.contains(delete)) {
                    returnList.add(str);
                }
            }

            // 当读取的一行不为空时,把读到的str的值赋给str1

            System.out.println(str1);// 打印出str1

        } catch (FileNotFoundException e) {

            System.out.println("找不到指定文件");

        } catch (IOException e) {

            System.out.println("读取文件失败");

        } finally {

            try {

                br.close();

                isr.close();

                fis.close();

// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
        return returnList;
    }
}
