package com.mdemydovych.nadiya.storage.aspect;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class SecurityAspect {

  private static final String KEY_HEADER_NAME = "secretKey";

  private final HttpServletRequest request;

  @Value("${storage.sec.key}")
  private String secretKey;

  @SneakyThrows
  @Around("@within(org.springframework.web.bind.annotation.RestController)")
  public Object security(ProceedingJoinPoint joinPoint) throws BeansException {
    checkRequestKey();
    return joinPoint.proceed(joinPoint.getArgs());
  }

  @SneakyThrows
  private void checkRequestKey() {
    String key = request.getHeader(KEY_HEADER_NAME);
    if (StringUtils.isBlank(key) || !key.equals(secretKey)) {
      throw new AccessDeniedException("Invalid or empty secret key");
    }
  }
}
