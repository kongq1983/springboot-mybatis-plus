package com.kq.swagger.contrller;


import com.kq.swagger.response.BaseResponse;
import com.kq.swagger.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kq
 * @date 2022-03-17 16:49
 * @since 2020-0630
 */

@Slf4j
@Api(tags = {"文件上传"},description = "文件上传1")
@RequestMapping("/upload")
@RestController
public class FileUploadController {




    @PostMapping(headers = "content-type=multipart/form-data")
//    @ApiOperation(value="文件上传",notes="文件上传-note",consumes="multipart/form-data")
    @ApiOperation(value="文件上传",notes="文件上传-note",consumes="application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "上传文件", type = "file",required = true,paramType = "form")
    })
//    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "string")
    public  BaseResponse<Object> uploadFileHandler(@RequestPart("file") MultipartFile file ) {

        log.debug("文件上传数据 filename={} size={}",file.getOriginalFilename(),file.getSize());

        return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);
    }


}
