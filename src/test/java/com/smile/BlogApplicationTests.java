package com.smile;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.text.resources.FormatData;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void dateTimeFormate() {
		
		DateFormateTest date = new DateFormateTest(LocalDate.now(),"myTime");
		System.out.println(date);
	}
	
	@Test
	public void date() {
		Instant instant = Instant.now();
		Date date = Date.from(instant);
		String format = DateFormatUtils.format(date, "yyyy-MM-dd  HH:mm:ss");
		System.out.println(format);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern("yyyy年MM月dd日 ");
		String format1 = simpleDateFormat.format(date);
		System.out.println(format1);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
	}

}
