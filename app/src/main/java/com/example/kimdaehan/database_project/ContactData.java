package com.example.kimdaehan.database_project;

public class ContactData
{
    private String name= null;
    private String make	= null;
    private String buy	= null;
    private String open	= null;
    private String store	= null;
    private String num	= null;

    public ContactData(String a,String b,String c,String d,String e,String f)
    {
        this.name = a;
        this.make = b;
        this.buy = c;
        this.open =d;
        this.store =e;
        this.num = f;
    }

    public String getName()
    {
        return this.name;
    }

    public String getMake()
    {
        return this.make;
    }

    public String getBuy()
    {
        return this.buy;
    }

    public String getOpen()
    {
        return this.open;
    }

    public String getStore()
    {
        return this.store;
    }

    public String getNum()
    {
        return this.num;
    }

    public String[] getCDataArray()
    {
        String[] cData = {
                this.name,
                this.make,
                this.buy,
                this.open,
                this.store,
                this.num
        };
        return cData;
    }
}