package entity;

import java.sql.Blob;

public class Face {
	private int id;
	private String face_token;
	private String face_name;
	private Blob image_byte; 
	private String name_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFace_token() {
		return face_token;
	}
	public void setFace_token(String face_token) {
		this.face_token = face_token;
	}
	public String getFace_name() {
		return face_name;
	}
	public void setFace_name(String face_name) {
		this.face_name = face_name;
	}
	public Blob getImage_byte() {
		return image_byte;
	}
	public void setImage_byte(Blob image_byte) {
		this.image_byte = image_byte;
	}
	public String getName_id() {
		return name_id;
	}
	public void setName_id(String name_id) {
		this.name_id = name_id;
	}
	public Face(int id, String face_token, String face_name, Blob image_byte, String name_id) {
		super();
		this.id = id;
		this.face_token = face_token;
		this.face_name = face_name;
		this.image_byte = image_byte;
		this.name_id = name_id;
	}
	
	public Face()
	{
		
	}
}
