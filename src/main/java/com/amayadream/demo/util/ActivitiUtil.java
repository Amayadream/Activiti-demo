package com.amayadream.demo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.dom4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * NAME   :  Activiti-demo/com.amayadream.demo.util
 * Author :  Amayadream
 * Date   :  2015.12.18 22:02
 * TODO   :  工作流工具类
 */
public class ActivitiUtil {

    private String name;
    private String groups;
    private String tools;

    /**
     * 获取字符串形式的模型xml,返回null则代表失败
     * @param modelId 模型编号
     * @return 字符串形式的模型xml
     */
    public String getStringXmlByByte(byte[] source) {
        try {
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            JsonNode editorNode = new ObjectMapper().readTree(source);
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
            // 处理异常
            if (bpmnModel.getMainProcess() == null) {
                return null;
            }
            byte[] exportBytes = null;
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            exportBytes = xmlConverter.convertToXML(bpmnModel);
            return new String(exportBytes, "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据字符串类型的xml解析出步骤名,角色以及工具
     * @param xml
     * @return
     */
    public List<ActivitiUtil> getInfoByStringXml(String xml){
        try {
            Document document = null;      //读取字符串形式的xml,转化成org.dom4j.document
            document = DocumentHelper.parseText(xml);
            //获取根节点元素对象
            Element definitions = document.getRootElement();    //根节点definitions
            Element process = definitions.element("process");   //二层节点process
            List<Element> userTasks = process.elements("userTask");     //用户任务,其中可以读取activiti:candidateGroups的属性,为角色组
            List<ActivitiUtil> list = new ArrayList<ActivitiUtil>();
            for (Element node : userTasks) {
                ActivitiUtil entity = new ActivitiUtil();
                Attribute name = node.attribute("name");
                Attribute groups = node.attribute("candidateGroups");
                Element documentation = node.element("documentation");
                if(name != null){
                    entity.setName(name.getStringValue());
                }
                if(groups != null){
                    entity.setGroups(groups.getStringValue());
                }
                if(documentation != null){
                    entity.setTools(documentation.getTextTrim());
                }
                list.add(entity);
            }
            return list;
        } catch (DocumentException e) {     //返回null
            e.printStackTrace();
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }
}
