package com.epyloc.pacs.exception;

public class PacsCriticalException extends Exception
{
  /**
  * Default Serial Version Id
  */
  private static final long serialVersionUID = 1L;



  /**
  * @param errorMessage Constructor used declare and define a exception
  */
  public PacsCriticalException(String errorMessage)
  {
    super(errorMessage);
  }

}