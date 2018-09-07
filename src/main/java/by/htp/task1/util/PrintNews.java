package by.htp.task1.util;

import by.htp.task1.entity.News;

import java.util.List;

public class PrintNews {
	
	public static void print(List<News> news) {
		if (news == null) {
			System.out.println("No news was found for the selected criteria");
		} else {
			System.out.println(news.toString());
		}
		
	}
}