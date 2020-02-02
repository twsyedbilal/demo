package com.techweaversys.conv;

import com.google.common.base.Function;
import com.techweaversys.dto.SchoolTypeDto;
import com.techweaversys.model.SchoolType;

public class SchoolTypeDtoConvertor implements Function<SchoolType, SchoolTypeDto>  {

	 @Override
     public SchoolTypeDto apply(SchoolType st) {
             
             SchoolTypeDto std=new SchoolTypeDto();
             std.setname(st.getname());
             std.setCode(st.getCode());
             std.setId(st.getId());
             return std;
     }


}
