package com.liu.service;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by 26522 on 2018/5/20.
 */
public class FMService {
    private static Configuration cfg;

    /**
     *
     * @param context:application
     * @param fname:转向的页的名字
     *             map:传值用的
     */
    public static void forward(ServletContext context,
                               String fname,
                               Map map,
                               HttpServletResponse response){

        cfg=new Configuration(Configuration.VERSION_2_3_23);
        //fm的家，

        cfg.setServletContextForTemplateLoading(context,"/WEB-INF/template");

        cfg.setDefaultEncoding("utf-8");
        Template t= null;
        try {
            t = cfg.getTemplate(fname+".ftl");
            response.setContentType("text/html");//设置头文件格式
            response.setCharacterEncoding(t.getEncoding());//设置编码
            PrintWriter out=response.getWriter();

            t.process(map,out);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
