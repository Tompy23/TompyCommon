/*---------------------------------------------------------------------
 * 
 * Copyright 2011 TransUnion LLC. All Rights Reserved.
 * 
 * No part of this work may be reproduced or distributed in any form or by any
 * means, electronic or otherwise, now known or hereafter developed, including,
 * but not limited to, the Internet, without the explicit prior written consent
 * from TransUnion LLC.
 * 
 * Requests for permission to reproduce or distribute any part of, or all of,
 * this work should be mailed to:
 * 
 * Law Department TransUnion 555 West Adams Chicago, Illinois 60661
 * www.transunion.com
 * 
 * ---------------------------------------------------------------------*/
package net.tompy.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonClassPathXmlApplicationContext extends ClassPathXmlApplicationContext 
{
    public CommonClassPathXmlApplicationContext(String s, Class<?> aClass) throws BeansException 
    {
        super(s, aClass);
    }

    public CommonClassPathXmlApplicationContext(String s) throws BeansException 
    {
        super(s);
    }

    public CommonClassPathXmlApplicationContext(String[] s) throws BeansException 
    {
        super(s);
    }

    protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader) 
    {
        beanDefinitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
        beanDefinitionReader.setNamespaceAware(true);
    }
}