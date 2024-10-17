package cl.villegas.mybatis.controller;

import cl.villegas.mybatis.util.ParameterUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cl.villegas.mybatis.util.TemplateUtil;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping(path = "/templates")
public class TemplateController {
    private static final Logger logger = Logger.getLogger(TemplateController.class);

    @Autowired
    private TemplateUtil TemplateUtil;

    @ApiOperation(value = "Retorna un template ya construido mediante los parametros ingresados")
    @GetMapping("{name}/{type}")
    public String generateTemplateByNameTypeAndParameters(@PathVariable(value = "name") String name, @PathVariable(value = "type") String type, HttpServletRequest httpServletRequest) {
        logger.info(String.format("Template %s.%s Generado", name, type));
        return TemplateUtil.generateTemplateByNameTypeAndParameters(name, type, ParameterUtil.getParameters(httpServletRequest));
    }
}