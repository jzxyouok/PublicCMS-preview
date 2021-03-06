package com.publiccms.views.controller.admin;

import static com.publiccms.common.constants.CommonConstants.getDefaultPage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UrlPathHelper;

import com.publiccms.common.base.AbstractController;

/**
 * 
 * IndexAdminController 统一分发Controller
 *
 */
@Controller
public class IndexAdminController extends AbstractController {
    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    /**
     * 页面请求统一分发
     * 
     * @param request
     * @return
     */
    @RequestMapping("/**")
    public String page(HttpServletRequest request) {
        String path = urlPathHelper.getLookupPathForRequest(request);
        if (notEmpty(path)) {
            if (SEPARATOR.equals(path) || path.endsWith(SEPARATOR)) {
                path += getDefaultPage();
            }
            int index = path.lastIndexOf(".");
            path = path.substring(path.indexOf(SEPARATOR) > 0 ? 0 : 1, index > -1 ? index : path.length());
        }
        return path;
    }
}