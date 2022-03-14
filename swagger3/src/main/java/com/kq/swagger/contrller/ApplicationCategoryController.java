package com.kq.swagger.contrller;


import com.kq.swagger.dto.ApplicationCategoryDTO;
import com.kq.swagger.dto.ApplicationCategorySearchDTO;
import com.kq.swagger.response.BaseResponse;
import com.kq.swagger.util.ResultCode;
import com.kq.swagger.validate.AddGroup;
import com.kq.swagger.validate.EditGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 应用分类
 * http://api.easytong.com/v2/users 非api不用版本号
 * @author kq
 * @date 2022-03-10 11:04
 * @since 2022
 */

@RestController
@Api(tags = {"应用分类"},description = "应用分类")
@RequestMapping("/app/category")
public class ApplicationCategoryController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(ApplicationCategoryController.class);



    @GetMapping()
    @ApiOperation(value="获取应用分类-信息",notes="GET")
    public BaseResponse<ApplicationCategoryDTO> getCategory(@ApiParam(name="id",value="分类ID",required=true) @RequestParam  String id){

        logger.debug("查看分类接收参数:id={}",id);

        try {
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }

    }



    @GetMapping("list")
    @ApiOperation(value="获取应用分类-列表",notes="GET")
    public BaseResponse<List<ApplicationCategoryDTO>> list(ApplicationCategorySearchDTO dto){

        logger.debug("分类搜索接收参数:{}",dto);

        List<ApplicationCategoryDTO> result = null;

        return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,result);
    }


    @PostMapping()
    @ApiOperation(value="新增应用分类",notes="ADD")
    public BaseResponse<Object> addCategory(@Validated({AddGroup.class}) @RequestBody ApplicationCategoryDTO dto){

        logger.debug("新增分类接收参数:{}",dto);


        try {
            dto.setId(null); // 新增接口没有id的值
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }

    }


    @PutMapping()
    @ApiOperation(value="修改应用分类",notes="UPDATE")
    public BaseResponse<Object> editCategory(@Validated({EditGroup.class}) @RequestBody ApplicationCategoryDTO dto){
        logger.debug("修改分类接收参数:{}",dto);
        try {
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }

    }


    @DeleteMapping()
    @ApiOperation(value="删除应用分类",notes="DELETE")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "分类ID", paramType = "query", dataType = "String", required = true)
//    })
    public BaseResponse<Object> deleteCategory(@ApiParam(name="id",value="分类ID",required=true)  @RequestParam String id){
        logger.debug("删除分类接收参数:id={}",id);
        try {
            return new BaseResponse<>(ResultCode.SUCCESS.getCode(),null,null);

        }catch (Exception e) {
            return new BaseResponse<>(ResultCode.FAIL.getCode(),e.getMessage(),null);
        }
    }



}
