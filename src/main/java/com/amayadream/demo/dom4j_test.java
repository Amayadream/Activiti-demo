package com.amayadream.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.amayadream.demo.util.ActivitiUtil;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo
 * Author :  Amayadream
 * Date   :  2015.12.18 14:52
 * TODO   :
 */
public class dom4j_test {

    private String test = "C:\\Users\\Administrator\\Desktop\\test.xml";
    private String bpmn = "C:\\Users\\Administrator\\Desktop\\experiment.bpmn20.xml";

    @Test
    public void asd()  throws Exception{
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(bpmn));
        //获取根节点元素对象
        Element definitions = document.getRootElement();    //根节点definitions
        Element process = definitions.element("process");   //二层节点process
        Element userTask = process.element("userTask");   //三层节点userTask    用户任务,其中可以读取activiti:candidateGroups的属性,为角色组
        Element documentation = userTask.element("documentation");  //四层节点documentation  模型工具
        Attribute candidateGroups = userTask.attribute("name");
        System.out.println(candidateGroups.getStringValue());
        System.out.println(documentation.getTextTrim());
    }

    @Test
    public void getXmlInfo() throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(bpmn));
//        Document document1 = DocumentHelper.parseText(string);
        //获取根节点元素对象
        Element definitions = document.getRootElement();    //根节点definitions
        Element process = definitions.element("process");   //二层节点process
        List<Element> userTasks = process.elements("userTask");     //用户任务,其中可以读取activiti:candidateGroups的属性,为角色组
        List<ActivitiUtil> list = new ArrayList<ActivitiUtil>();
        for (Element node : userTasks) {
            ActivitiUtil bpmnEntity = new ActivitiUtil();
            Attribute name = node.attribute("name");
            Attribute candidateGroups = node.attribute("candidateGroups");
            Element documentation = node.element("documentation");
            if(name != null){
                bpmnEntity.setName(name.getStringValue());
            }
            if(candidateGroups != null){
                bpmnEntity.setGroups(candidateGroups.getStringValue());
            }
            if(documentation != null){
                bpmnEntity.setTools(documentation.getTextTrim());
            }
            list.add(bpmnEntity);
        }
        System.out.println(JSON.toJSON(list));
    }

    @Test
    public void test() throws Exception{
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(test));
        //获取根节点元素对象
        Element root = document.getRootElement();
        //遍历
        listNodes(root);
    }

    //遍历当前节点下的所有节点
    public void listNodes(Element node){
        System.out.println("当前节点的名称：" + node.getName());
        //首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        //遍历属性节点
        for(Attribute attribute : list){
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());
        }
        //如果当前节点内容不为空，则输出
        if(!(node.getTextTrim().equals(""))){
            System.out.println( node.getName() + "：" + node.getText());
        }
        //同时迭代当前节点下面的所有子节点
        //使用递归
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }


    //操作节点
    @Test
    public void test2()throws Exception{
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(test));
        //获取根节点元素对象
        Element root = document.getRootElement();

        System.out.println("-------添加属性前------");
        //获取节点student1
        Element student1Element = root.element("student1");
        //遍历
        listNodes(student1Element);
        //获取其属性
        Attribute idAttribute = student1Element.attribute("id");
        //删除其属性
        student1Element.remove(idAttribute);
        //为其添加新属性
        student1Element.addAttribute("name", "这是student1节点的新属性");
        System.out.println("-------添加属性后------");
        listNodes(student1Element);
    }

    //添加节点
    @Test
    public void test3()throws Exception{
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(test));
        //获取根节点元素对象
        Element root = document.getRootElement();
        System.out.println("-------添加节点前------");
        //获取节点student1
        Element student1Element = root.element("student1");
        //遍历
        listNodes(student1Element);
        //添加phone节点
        Element phoneElement = student1Element.addElement("phone");
        //为phone节点设置值
        phoneElement.setText("137xxxxxxxx");
        System.out.println("-------添加节点后------");
        listNodes(student1Element);
    }

    //添加节点后，写入新的文件
    @Test
    public void test4()throws Exception{
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File(test));
        //获取根节点元素对象
        Element root = document.getRootElement();
        System.out.println("-------添加节点前------");
        //获取节点student1
        Element student1Element = root.element("student1");
        //遍历
        listNodes(student1Element);
        //添加phone节点
        Element phoneElement = student1Element.addElement("phone");
        //为phone节点设置值
        phoneElement.setText("137xxxxxxxx");
        System.out.println("-------添加节点后------");
        listNodes(student1Element);
        //把student1Element写入新文件
        writerDocumentToNewFile(document);
        System.out.println("---写入完毕----");
    }

    //document写入新的文件
    public void writerDocumentToNewFile(Document document)throws Exception{
        //输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置编码
        format.setEncoding("UTF-8");
        //XMLWriter 指定输出文件以及格式
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(test)),"UTF-8"), format);

        //写入新文件
        writer.write(document);
        writer.flush();
        writer.close();
    }
}