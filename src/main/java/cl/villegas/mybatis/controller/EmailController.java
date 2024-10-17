package cl.villegas.mybatis.controller;

import java.io.IOException;
import cl.villegas.mybatis.util.ParameterUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cl.villegas.mybatis.util.EmailUtil;
import cl.villegas.mybatis.util.ReportUtil;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping("correos")
public class EmailController {
    private static final Logger logger = Logger.getLogger(EmailController.class);

    @Autowired
    private ReportUtil reportUtil;

    @ApiOperation(value = "Envio de texto plano")
    @GetMapping(path = "plain-text")
    @ResponseStatus(HttpStatus.OK)
    public String sendPlainText(@RequestParam(value = "toEmail") String toEmail, @RequestParam(value = "subject") String subject, @RequestParam(value = "body") String body) {
        logger.info("Envio de correo con texto plano ejecutado");
        EmailUtil.sendPlainText(toEmail, subject, body);
        return "Envio de correo con texto plano ejecutado";
    }

    @ApiOperation(value = "Envio de html")
    @GetMapping(path = "html")
    @ResponseStatus(HttpStatus.OK)
    public String sendHtml(@RequestParam(value = "toEmail") String toEmail, @RequestParam(value = "subject") String subject, @RequestParam(value = "html") String html) {
        logger.info("Envio de correo con html ejecutado");
        EmailUtil.sendHtml(toEmail, subject, html);
        return "Envio de correo con html ejecutado";
    }

    @ApiOperation(value = "Envio de archivo")
    @PostMapping(path = "file")
    @ResponseStatus(HttpStatus.OK)
    public String sendFile(@RequestParam(value = "toEmail") String toEmail, @RequestParam(value = "subject") String subject,
                           @RequestParam(value = "body") String body, @RequestParam(value = "file") MultipartFile file) {
        String salida = "Envio de correo con archivo ejecutado exitosamente";
        try {
            EmailUtil.sendFile(toEmail, subject, body, file.getOriginalFilename(), file.getContentType(), file.getBytes());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            salida = "Envio de correo con archivo con problemas";
        }
        return salida;
    }

    @ApiOperation(value = "Envio de reporte")
    @GetMapping(path = "report")
    @ResponseStatus(HttpStatus.OK)
    public String sendReport(@RequestParam(value = "toEmail") String toEmail, @RequestParam(value = "subject") String subject,
                             @RequestParam(value = "body") String body, @RequestParam(value = "name") String name,
                             @RequestParam(value = "type") String type, HttpServletRequest httpServletRequest) {
        EmailUtil.sendReport(toEmail, subject, body, name, type,
                reportUtil.generateReportBytesByNameAndParametersAndType(name, type, ParameterUtil.getParameters(httpServletRequest)));
        return "Envio de correo con reporte ejecutado";
    }
}