package com.shall.cim.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shall.cim.dao.ComplaintsConsumerDAO;
import com.shall.cim.frontend.dao.dto.Complaint;

@Component(value = "itemMB")
@ManagedBean(name = "itemMB")
@ViewScoped
public class ItemMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ComplaintsConsumerDAO complaintsDao;

	private Complaint bean;
	private Complaint beanSelected;
	private List<Complaint> list;
	private List<Complaint> listSelected;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		System.out.println("In refresh list");
		this.bean = new Complaint();
		this.beanSelected = new Complaint();
		this.list = new ArrayList<Complaint>();
		this.listSelected = new ArrayList<Complaint>();
		try {
			System.out.println("**************** Fetch all items ******************");
			this.list.addAll(complaintsDao.findAllComplaints());
			this.listSelected.addAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void save() {
		try {
			bean.setOpen("true");
			bean.setComplaintOpeningTime(LocalDateTime.now().toString());
			complaintsDao.persist(this.bean);
			refreshList();
			notificationSuccess("Adding complaint!");
		} catch (Exception e) {
			notificationError(e, "Adding complaint!");
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			complaintsDao.merge(this.beanSelected);
			refreshList();
			notificationSuccess("Updated complaint!");
		} catch (Exception e) {
			notificationError(e, "Updating complaint!");
		}
	}

	public void delete() {
		try {
			complaintsDao.remove(this.beanSelected.getComplaintId());
			refreshList();
			notificationSuccess("Deleted complaint!");
		} catch (Exception e) {
			notificationError(e, "Deleting complaint!");
		}
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	public void reset() {
		refreshList();
		RequestContext.getCurrentInstance().reset("form1:panel");
	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public ComplaintsConsumerDAO getComplaintsDao() {
		return complaintsDao;
	}

	public void setComplaintsDao(ComplaintsConsumerDAO complaintsDao) {
		this.complaintsDao = complaintsDao;
	}

	public Complaint getBean() {
		return bean;
	}

	public void setBean(Complaint bean) {
		this.bean = bean;
	}

	public Complaint getBeanSelected() {
		return beanSelected;
	}

	public void setBeanSelected(Complaint beanSelected) {
		this.beanSelected = beanSelected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Complaint> getList() {
		if (list == null) {
			list = new ArrayList<Complaint>();
		}
		return list;
	}

	public void setList(List<Complaint> list) {
		this.list = list;
	}

	public List<Complaint> getListSelected() {
		return listSelected;
	}

	public void setListSelected(List<Complaint> listSelected) {
		this.listSelected = listSelected;
	}

	public String reloadAllItems() {
		System.out.println("*********** Reloading page ****************");
		refreshList();
		return "/views/items/all.xhtml";
	}

}
