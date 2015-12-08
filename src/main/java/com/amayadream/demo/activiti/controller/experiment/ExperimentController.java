package com.amayadream.demo.activiti.controller.experiment;

import com.amayadream.demo.activiti.service.experiment.ExperimentWorkflowService;
import com.amayadream.demo.pojo.Experiment;
import com.amayadream.demo.service.IExperimentService;
import com.amayadream.demo.util.Page;
import com.amayadream.demo.util.PageUtil;
import com.amayadream.demo.util.UserUtil;
import com.amayadream.demo.util.Variable;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 请假控制器，包含保存、启动流程
 * 
 * @author HenryYan
 */
@Controller
@RequestMapping(value = "/oa/leave")
public class ExperimentController {

  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired protected ExperimentWorkflowService workflowService;
  @Autowired protected RuntimeService runtimeService;
  @Autowired protected TaskService taskService;

  @Resource private IExperimentService experimentService;

  @RequestMapping(value = { "apply", "" })
  public String createForm(Model model) {
    model.addAttribute("experiment", new Experiment());
    return "/oa/leave/leaveApply";
  }

  /**
   * 启动请假流程
   * 
   * @param experiment
   */
  @RequestMapping(value = "start", method = RequestMethod.POST)
  public String startWorkflow(Experiment experiment, RedirectAttributes redirectAttributes, HttpSession session) {
    try {
      User user = UserUtil.getUserFromSession(session);
      experiment.setUserid(user.getId());
      Map<String, Object> variables = new HashMap<String, Object>();
      ProcessInstance processInstance = workflowService.startWorkflow(experiment, variables);
      redirectAttributes.addFlashAttribute("message", "流程已启动，流程ID：" + processInstance.getId());
    } catch (ActivitiException e) {
      if (e.getMessage().indexOf("no processes deployed with key") != -1) {
        logger.warn("没有部署流程!", e);
        redirectAttributes.addFlashAttribute("error", "没有部署流程，请在[工作流]->[流程管理]页面点击<重新部署流程>");
      } else {
        logger.error("启动请假流程失败：", e);
        redirectAttributes.addFlashAttribute("error", "系统内部错误！");
      }
    } catch (Exception e) {
      logger.error("启动请假流程失败：", e);
      redirectAttributes.addFlashAttribute("error", "系统内部错误！");
    }
    return "redirect:/oa/leave/apply";
  }

  /**
   * 任务列表
   */
  @RequestMapping(value = "list/task")
  public ModelAndView taskList(HttpSession session, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/oa/leave/taskList");
    Page<Experiment> page = new Page<Experiment>(PageUtil.PAGE_SIZE);
    int[] pageParams = PageUtil.init(page, request);
    String userId = UserUtil.getUserFromSession(session).getId();
    workflowService.findTodoTasks(userId, page, pageParams);
    mav.addObject("page", page);
    return mav;
  }

  /**
   * 读取运行中的流程实例
   * 
   * @return
   */
  @RequestMapping(value = "list/running")
  public ModelAndView runningList(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/oa/leave/running");
    Page<Experiment> page = new Page<Experiment>(PageUtil.PAGE_SIZE);
    int[] pageParams = PageUtil.init(page, request);
    workflowService.findRunningProcessInstaces(page, pageParams);
    mav.addObject("page", page);
    return mav;
  }

  /**
   * 读取运行中的流程实例
   * 
   * @return
   */
  @RequestMapping(value = "list/finished")
  public ModelAndView finishedList(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/oa/leave/finished");
    Page<Experiment> page = new Page<Experiment>(PageUtil.PAGE_SIZE);
    int[] pageParams = PageUtil.init(page, request);
    workflowService.findFinishedProcessInstaces(page, pageParams);
    mav.addObject("page", page);
    return mav;
  }

  /**
   * 签收任务
   */
  @RequestMapping(value = "task/claim/{id}")
  public String claim(@PathVariable("id") String taskId, HttpSession session, RedirectAttributes redirectAttributes) {
    String userId = UserUtil.getUserFromSession(session).getId();
    taskService.claim(taskId, userId);
    redirectAttributes.addFlashAttribute("message", "任务已签收");
    return "redirect:/oa/leave/list/task";
  }

  /**
   * 读取详细数据
   * 
   * @param id
   * @return
   */
  @RequestMapping(value = "detail/{id}")
  @ResponseBody
  public Experiment getExperiment(@PathVariable("id") String id) {
    Experiment experiment = experimentService.selectExperimentById(id);
    return experiment;
  }

  /**
   * 读取详细数据
   * @param id
   * @return
   */
  @RequestMapping(value = "detail-with-vars/{id}/{taskId}")
  @ResponseBody
  public Experiment getExperimentWithVars(@PathVariable("id") String id, @PathVariable("taskId") String taskId) {
    Experiment experiment = experimentService.selectExperimentById(taskId);
    Map<String, Object> variables = taskService.getVariables(taskId);
    experiment.setVariables(variables);
    return experiment;
  }

  /**
   * 完成任务
   * 
   * @param taskId
   * @return
   */
  @RequestMapping(value = "complete/{id}", method = { RequestMethod.POST, RequestMethod.GET })
  @ResponseBody
  public String complete(@PathVariable("id") String taskId, Variable var) {
    try {
      Map<String, Object> variables = var.getVariableMap();
      taskService.complete(taskId, variables);
      return "success";
    } catch (Exception e) {
      logger.error("error on complete task {}, variables={}", new Object[] { taskId, var.getVariableMap(), e });
      return "error";
    }
  }

}
