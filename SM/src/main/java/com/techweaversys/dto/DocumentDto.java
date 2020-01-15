package com.techweaversys.dto;

import java.util.Arrays;

import com.techweaversys.model.Admission;

public class DocumentDto {

	private Long id;
	private String fileName;
	private String fileType;
	private String name;
	private String path;
	private String store;
	private String url;
	private byte[] doc;
	private Admission admission;

	public DocumentDto() {
		super();
	}

	public DocumentDto(Long id, String fileName, String fileType, String name, String path, String store, String url,
			byte[] doc, Admission admission) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.name = name;
		this.path = path;
		this.store = store;
		this.url = url;
		this.doc = doc;
		this.admission = admission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(doc);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentDto other = (DocumentDto) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(doc, other.doc))
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
		return "DocumentDto [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", name=" + name
				+ ", path=" + path + ", store=" + store + ", url=" + url + ", doc=" + Arrays.toString(doc)
				+ ", admission=" + admission + "]";
	}

}
