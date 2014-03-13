package com.controller.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.business.IAfficherListeHotels;
import com.business.impl.AfficherListeHotelsImpl;
import com.model.Ville;



@ManagedBean
@SessionScoped
public class ListeVilleConverter implements Converter {
	
	private  List<Ville> villeDb;
	@ManagedProperty("#{hotelBusiness}")
	IAfficherListeHotels aff;
	
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		if(arg2.trim().equals("")){
			return null;
		}else{
			try{
				for( Ville p: getVilleDb()){
					System.out.println(p.getNomVille());
					if(p.getNomVille().equalsIgnoreCase(arg2))
						
						return p;
						
				}
				}catch(Exception e){
					e.printStackTrace();
					throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Conversion Error","Ville non valide"));
				}
				
			}
		return null;
		
	}
		
	
 
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2==null || arg2==""){
			return "";
		}else{
		
			return  String.valueOf(((Ville) arg2).getNomVille());  
		}
		
	}
	


	
	public List<Ville> getVilleDb() {
		
		villeDb=new ArrayList<Ville>();
		villeDb=aff.findAll();
		Iterator<Ville> it=villeDb.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getNomVille());
		}
		return villeDb;
	}



	public IAfficherListeHotels getAff() {
		return aff;
	}



	public void setAff(IAfficherListeHotels aff) {
		this.aff = aff;
	}	

}
