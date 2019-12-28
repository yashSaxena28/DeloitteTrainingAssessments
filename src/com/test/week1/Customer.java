package com.test.week1;

import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class Customer implements Comparable 
{
	private int id;
	private String name,email;
	private long mobileNo;
	
	public Customer(int id,String name,String email,long mobileNo)
	{
		this.id=id;
		this.name=name;
		this.email=email;
		this.mobileNo=mobileNo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public int compareTo(Object o) {
		Customer c=(Customer)o;
		return c.getId()-this.getId();
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}

	public static void main(String[] args)
	{
		Customer[] c=new Customer[10];
		c[0]=new Customer(1,"AB","ab@ab.com",11223344);
		c[1]=new Customer(2,"CD","cd@ab.com",22334455);
		c[2]=new Customer(3,"EF","ef@ab.com",33445566);
		c[3]=new Customer(4,"GH","gh@ab.com",44556677);
		int index=3;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Login ID : ");
		String logID=sc.nextLine();
		System.out.print("Enter Password : ");
		String logpwd=sc.nextLine();
		
		if(logID.equals("ABCCust") && logpwd.equals("abc@123"))
		{
			System.out.print("Please Choose Your Choice :1. Add\n 2. Print\n 3. Edit\n 4. Delete\n 5.Exit\nPlease Choose Your Choice : ");
			short choice=sc.nextShort();
			do
			{
				switch(choice)
				{
				case 1:
					if(index<9)
					{
						System.out.print("Enter id:");
						int id=sc.nextInt();
						System.out.print("Enter name:");
						String n=sc.nextLine();
						String name=sc.nextLine();
						System.out.print("Enter email:");
						String email=sc.nextLine();
						System.out.print("Enter mobile no.:");
						long mobileNo=sc.nextLong();
						c[index+1]=new Customer(id,name,email,mobileNo);
						index++;
						System.out.println("Added Successfully");
						break;
					}
					System.out.println("List is full cannot add new member, sorry for inconvience");
					break;
				case 2:
					System.out.println("List of Members : \n");
					for(int i=0;i<=index;i++)
					{
						System.out.print(c[i]+"\n");
					}
					break;
				case 3:
					System.out.print("Enter Id: ");
					int id=sc.nextInt();
					System.out.print("Enter Name: ");
					String name=sc.nextLine();
					System.out.print("Enter Email: ");
					String email=sc.nextLine();
					System.out.print("Enter Mobile No.: ");
					long mobileNo=sc.nextLong();
					for(int i=0;i<=index;i++)
					{
						if(id==c[i].getId())
						{
							c[i].setName(name);
							c[i].setEmail(email);
							c[i].setMobileNo(mobileNo);
						}
					}
					break;
				case 4:
					if(index>=0)
					{
						System.out.print("Enter Id: ");
						int eid=sc.nextInt();
						for(int i=0;i<=index;i++)
						{
							if(eid==c[i].getId())
							{
								for(int j=i;j<index;j++)
								{
									c[j]=c[j+1];
								}
								c[index]=null;
								index--;
							}
						}
						System.out.println("Member Deleted Successfully\nList of Members : \n");
						for(int i=0;i<=index;i++)
						{
							System.out.print(c[i]+"\n");
						}
						break;
					}
					System.out.print("List is empty nothing to delete, please add Members before deleting them.");
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("INVALID CHOICE:");
				}
				System.out.print("Please Choose Your Choice :1. Add\n 2. Print\n 3. Edit\n 4. Delete\n 5.Exit\nPlease Choose Your Choice : ");
				choice=sc.nextShort();		
			}while(choice<5);
		}	
		sc.close();
	}
}
