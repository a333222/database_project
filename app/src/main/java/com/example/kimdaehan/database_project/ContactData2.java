package com.example.kimdaehan.database_project;

public class ContactData2
{
    private String name= null;
    private String fff	= null;
    private String care	= null;

    public ContactData2(String a,String b,String c)
    {
        this.name = a;
        this.fff = b;
        this.care = c;
    }

    public String getName()
    {
        return this.name;
    }

    public String getFff()
    {
        return this.fff;
    }

    public String getCare()
    {
        return this.care;
    }


    public String[] getCDataArray()
    {
        String[] cData = {
                this.name,
                this.fff,
                this.care
        };
        return cData;
    }
}