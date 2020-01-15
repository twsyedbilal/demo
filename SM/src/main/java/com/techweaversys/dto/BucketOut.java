package com.techweaversys.dto;

public class BucketOut {

	private Long rowId;
	private String fileType;
	private String path;

	public BucketOut() {
		super();
	}

	public BucketOut(Long rowId, String fileType, String path) {
		super();
		this.rowId = rowId;
		this.fileType = fileType;
		this.path = path;
	}

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((rowId == null) ? 0 : rowId.hashCode());
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
		BucketOut other = (BucketOut) obj;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (rowId == null) {
			if (other.rowId != null)
				return false;
		} else if (!rowId.equals(other.rowId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BucketOut [rowId=" + rowId + ", fileType=" + fileType + ", path=" + path + "]";
	}

}
