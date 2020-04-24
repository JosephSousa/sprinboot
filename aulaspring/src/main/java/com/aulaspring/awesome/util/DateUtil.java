package com.aulaspring.awesome.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joseph
 * @Email jsantos.te@gmail.com
 */
@Component
public class DateUtil {
      
    public String formatDateTimeToDataBaseStyle(LocalDateTime date){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
