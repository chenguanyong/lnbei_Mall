package com.lnbei.framework.tag;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;
public class LBDialect extends AbstractProcessorDialect {
	
	private static final String DIALECT_NAME = "LB Dialect";
	private static final String PREFIX = "LB";
	public LBDialect() {
		super(DIALECT_NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		// TODO Auto-generated method stub
        Set<IProcessor> processors = new HashSet<IProcessor>();

        // 添加自定义标签
        processors.add(new LbCategoryTagProcessor(dialectPrefix));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
	}

}
