package com.lambert.fun.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "日记接口")
@RequestMapping("diary")
public class DiaryController {
}
