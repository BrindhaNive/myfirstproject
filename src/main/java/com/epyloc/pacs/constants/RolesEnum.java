package com.epyloc.pacs.constants;

public enum RolesEnum {
	DEFAULT("DEFAULT","DEFAULT"),
	BANK_USER("BANK USER", "BU"),
	TALUK_USER("TALUK USER", "TU"),
	DISTRICT_USER("DISTRICT USER", "DU"),
	STATE_USER("STATE USER", "SU");
	
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
