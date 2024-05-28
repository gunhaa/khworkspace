package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {


	public void practice() {
		
		Book b1 = new Book();

		System.out.println(b1.getTitle()+" / "+b1.getPrice()+" / "+b1.getDiscountRate()+" / "+b1.getAuthor());

		Book b2 = new Book();

		b2 = new Book("자바의 정석",30000 ,0.2 , "남궁성" );

		
		System.out.println(b2.getTitle()+" / "+b2.getPrice()+" / "+b2.getDiscountRate()+" / "+b2.getAuthor());


		System.out.println("==============================");


		b1.setTitle("C언어");
		b1.setPrice(30000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("홍길동");

		System.out.println("수정된 결과 확인");
		System.out.println(b1.getTitle()+" / "+b1.getPrice()+" / "+b1.getDiscountRate()+" / "+b1.getAuthor());
		System.out.println("==============================");


		System.out.printf("도서명 = %s \n할인된 가격 = %d원\n",
				b1.getTitle(), (int)( b1.getPrice() - ( b1.getPrice() *b1.getDiscountRate() ) ));
		System.out.printf("도서명 = %s \n할인된 가격 = %d원\n",
				b2.getTitle(), (int)( b2.getPrice() - ( b2.getPrice() *b2.getDiscountRate() ) ));
		//가능				30000			30000    x     0.1
		b1.setPrice((int)(b1.getPrice()-(b1.getPrice()*b1.getDiscountRate())));
	
		System.out.println(b1.getPrice());

	}


}
