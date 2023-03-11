class BookData
{
	private String name;
	private String author;
	private String company;
	private String number;
	private String sort;
	private String year;
	
	public BookData()
	{
		name = null;
		author = null;
		company = null;
		number = null;
		sort = null;
		year = null;
	}
	
	public BookData(String name, String author, String company, String number, String sort, String year)
	{
		setName(name);
		setAuthor(author);
		setCompany(company);
		setNumber(number);
		setSort(sort);
		setYear(year);
	}
   
	public boolean setName(String newname)
	{
		if(newname.equals(null))
		{
			System.out.print("錯誤！！請重新輸入書名：");
			return false;
		}
		else
		{
			name = newname;
			return true;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean setAuthor(String newauthor)
	{
		if(newauthor.equals(null))
		{
			System.out.print("錯誤！！請重新輸入作者：");
			return false;
		}
		else
		{
			author = newauthor;
			return true;
		}
	}

	public String getAuthor()
	{
		return author;
	}

	public boolean setCompany(String newcompany)
	{
		if(newcompany.equals(null))
		{
			System.out.print("錯誤！！請重新輸入出版社：");
			return false;
		}
		else
		{
			company = newcompany;
			return true;
		}
    }

	public String getCompany()
	{
		return company;
	}

	public boolean setNumber(String newnumber)
	{
		if(newnumber.length() == 6 && newnumber.substring(0, 1).matches("[A-Za-z]") && newnumber.substring(1).matches("[0-9]{5}"))
		{
			number = newnumber;
			return true;
		}
		else
		{
			System.out.print("錯誤！！請重新輸入編號：");
			return false;
		}
    }

	public String getNumber()
	{
		return number;
	}

	public boolean setSort(String newsort)
	{
		if(newsort.equals(null))
		{
			System.out.print("錯誤！！請重新輸入類別：");
			return false;
		}
		else
		{
			sort = newsort;
			return true;
		}
    }

	public String getSort()
	{
		return sort;
	}

	public boolean setYear(String newyear)
	{
		if(newyear.length() == 4 && newyear.matches("[0-9]{4}"))
		{
			year = newyear;
			return true;
		}
		else
		{
			System.out.print("錯誤！！請重新輸入出版年份：");
			return false;
		}
    }

	public String getYear()
	{
		return year;
	}
}