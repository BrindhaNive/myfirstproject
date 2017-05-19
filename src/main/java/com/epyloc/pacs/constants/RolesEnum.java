package com.epyloc.pacs.constants;

public enum RolesEnum {
	
	DEFAULT("DEFAULT","DEFAULT"),
	SITE_ADMIN("Site Admin", "Admin"),
	BANK_MANAGER("Bank Manager", "BM"),
	JOINT_REGISTAR("Joint Registar", "JR");
	
	private String roleName;
	private String shortName;

	RolesEnum(String roleName, String shortName)	{
		this.roleName = roleName;
		this.shortName = shortName;
	}
	
	public String getRoleName()	{
		return this.roleName;
	}
	
	public String getshortName()	{
		return this.shortName;
	}
	
	public static RolesEnum getEnumByRoleName(String roleName)	{
		for(RolesEnum value: RolesEnum.values())	{
			if(value.getRoleName().equals(roleName))	{
				return value;
			}
		}
		return null;
	}	
	
}
