package com.xspace.module;

import java.util.ArrayList;

/**
 * <一句话功能简述> <模板数据>
 *
 * @author jixiongxu
 * @version [版本号, 2018/1/9]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

public class TemplateModule extends BaseModule
{
    public String templateId;

    public String img_url;

    public String title;

    public String subtitle;

    public String description;

    public String type;

    public String link;

    public ArrayList<TemplateItem> templateItems;

    /**
     * <一句话功能简述> <模板中的item数据>
     *
     * @author jixiongxu
     * @version [版本号, 2018/1/11]
     * @see [相关类/方法]
     * @since [产品/模块版本]
     */

    public static class TemplateItem extends BaseModule
    {
        public String type;

        public String link;

        public String img_url;

        public String title;

        public String subtitle;

        public String description;
    }

}
