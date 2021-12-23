package fr.diginamic.jdbc.entites;

public class Fournisseur 
{
	private Integer id;
	private String name;
	
	public Fournisseur(String name) 
	{
		super();
		this.name = name;
	}
	
	public Fournisseur(Integer id, String name) 
	{
		this(name);
		this.id = id;
	}

	@Override
	public String toString() 
	{
		return "Fournisseur [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}
