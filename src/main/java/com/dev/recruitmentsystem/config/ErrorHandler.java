package com.dev.recruitmentsystem.config;

//import com.dev.recruitmentsystem.utils.AuthenticationException;
import com.dev.recruitmentsystem.utils.CustomErrorResponseContent;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

/*    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<Map<String, Object>> handleAccessDeniedExceptions(HttpServletRequest request, Exception ex) {
        CustomErrorResponseContent _err = new CustomErrorResponseContent(HttpStatus.FORBIDDEN.toString(), ex.getMessage());
        return new ResponseEntity<>(_err.getRes(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Map<String, Object>> handleAuthenticationException(HttpServletRequest request, Exception ex) {
        CustomErrorResponseContent _err = new CustomErrorResponseContent(HttpStatus.UNAUTHORIZED.toString(), ex.getMessage());
        return new ResponseEntity<>(_err.getRes(), HttpStatus.UNAUTHORIZED);
    }*/

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Map<String, Object>> handleAllExceptions(HttpServletRequest request, Exception ex) {
        String ck = ex.getCause().toString();
/*        if (ck != null) {
            switch (ck) {
                case "com.hotelmanagement.Utils.AuthenticationException: Unauthorized": {
                    return this.handleAuthenticationException(request, new AuthenticationException("Unauthorized"));
                }
            }
        }*/
        CustomErrorResponseContent _err = new CustomErrorResponseContent(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return new ResponseEntity<>(_err.getRes(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
