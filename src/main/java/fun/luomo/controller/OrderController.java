package fun.luomo.controller;

import com.github.pagehelper.PageInfo;
import fun.luomo.domain.Orders;
import fun.luomo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/15 14:22
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Secured("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize
    ) throws Exception {

        List<Orders> orderList = orderService.findAll(page, pageSize);
        ModelAndView mv = new ModelAndView();

        PageInfo pageInfo = new PageInfo(orderList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(
            @RequestParam(name = "id", required = true) String orderId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders=orderService.findById(orderId);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }


}
