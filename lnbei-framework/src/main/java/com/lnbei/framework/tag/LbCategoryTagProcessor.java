package com.lnbei.framework.tag;

import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;

//import org.thymeleaf.spring4.context.SpringContextUtils;

/**
 * 类别标签
 * @author chen
 *
 */
public class LbCategoryTagProcessor extends AbstractElementTagProcessor  {
    // 标签名
    private static final String TAG_NAME = "category";

    // 优先级
    private static final int PRECEDENCE = 10000;
    
	public LbCategoryTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, PRECEDENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		  // 获取 Spring 上下文
//        ApplicationContext applicationContext = SpringContextUtils.getApplicationContext(context);
//
//        // 注入字典
//        DictService dictService = applicationContext.getBean(DubboContextUtils.class).getDictService();
//
//        // 从标签读取属性值，这里的值是用来作为字典的查询参数
//        String dictType = iProcessableElementTag.getAttributeValue("type");
//
//        // 提交表单时的 name
//        String dictName = iProcessableElementTag.getAttributeValue("name");
//
//        // 元素的 class 样式
//        String dictClass = iProcessableElementTag.getAttributeValue("class");
//
//        // 根据类型查询出字典列表
//        List<Dict> dictList = dictService.selectByType(dictType);
//
//        // 创建将替换自定义标签的 DOM 结构
//        IModelFactory modelFactory = iTemplateContext.getModelFactory();
//        IModel model = modelFactory.createModel();
//
//        // 这里是将字典的内容拼装成一个下拉框
//        model.add(modelFactory.createOpenElementTag(String.format("select name='%s' class='%s'", dictName, dictClass)));
//        for (Dict dict : dictList) {
//            model.add(modelFactory.createOpenElementTag(String.format("option value='%s'", dict.getValue())));
//            model.add(modelFactory.createText(dict.getLabel()));
//            model.add(modelFactory.createCloseElementTag("option"));
//        }
//        model.add(modelFactory.createCloseElementTag("select"));

        // 利用引擎替换整合标签
        //structureHandler.replaceWith(model, false);
		
	}

}
