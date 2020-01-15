package com.techweaversys.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.techweaversys.generics.AbstractPersistable;

@Entity
@Table(name = "sm_document")
@Where(clause = "deleted=false")
public class Document extends AbstractPersistable {

	private static final long serialVersionUID = 2178190290831862888L;

	@Column(name = "file_name", nullable = true)
	private String fileName;

	@Column(name = "file_type", nullable = true)
	private String fileType;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "path", nullable = true)
	private String path;

	@Column(name = "store", nullable = true)
	private String store;

	@Lob
	@Column(name = "doc", nullable = true)
	private byte[] doc;
	
	@Column(name = "url", nullable = true)
	private String url;

	public Document() {
		super();
	}

	public Document(String fileName, String fileType, String name, String path, String store, byte[] doc, String url) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.name = name;
		this.path = path;
		this.store = store;
		this.doc = doc;
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(doc);
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (!Arrays.equals(doc, other.doc))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [fileName=" + fileName + ", fileType=" + fileType + ", name=" + name + ", path=" + path
				+ ", store=" + store + ", url=" + url + ", doc=" + Arrays.toString(doc)
				+ "]";
	}
}
