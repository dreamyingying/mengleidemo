package com.menglei.family.account.config.shiro;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
  * @className SecureTag
  * @Description TODO
  * @date 2018/9/4 10:13
  * @author Menglei（lei.meng@cmgplex.com)
  * @version 1.0
  **/
public abstract class SecureTag implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {

    }
}
