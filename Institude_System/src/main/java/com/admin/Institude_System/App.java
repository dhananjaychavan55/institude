package com.admin.Institude_System;

import java.util.Scanner;

import com.service.CJC;
import com.service.CjcAkurdi;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CJC c=new CjcAkurdi();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		
		while(flag) {
			
			System.out.println("---------Welcome--------");
			System.out.println("1: AddCourse ");
			System.out.println("2: CreateBatch");
			System.out.println("3: AddFaculty ");
			System.out.println("4: AddStudent");
			System.out.println("5: ViewBatch");
			System.out.println("6: ViewFaculty");
			System.out.println("7: ViewStudent");
			System.out.println("8: ViewCourse");
			System.out.println("9: Exit ");
			
			int key=sc.nextInt();
			switch (key) {
			case 1:
				c.addCourse();
				break;
			case 2:
				c.createBatch();
				break;
			case 3:
				c.addFaculty();
				break;
			case 4:
				c.addStudent();
				break;
			case 5:
				c.viewBatch();
				break;
			case 6:
				c.viewFaculty();
				break;
			case 7:
				 c.viewStudent();
				break;
			case 8:
				c.viewCourse();
				break;
			case 9:
				   System.out.println("Thank You!!");
				   flag=false;
				break;

			default:
				System.out.println("Enter right option");
				break;
			}
						
			
		}
		
		
	}

    }

