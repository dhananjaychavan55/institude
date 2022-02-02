package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Faculty {

	@Id
	private int fid;
	private String fname;
	private String fbranch;
	@OneToMany
	private List<Batch>batches=new ArrayList<Batch>();

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	@Override
	public String toString() {
		return "Fid=" + fid + ", Fname=" + fname + ", Fbranch=" + fbranch + ", Batches=" + batches;
	}
	public String getFbranch() {
		return fbranch;
	}
	public void setFbranch(String fbranch) {
		this.fbranch = fbranch;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
		
	
}
