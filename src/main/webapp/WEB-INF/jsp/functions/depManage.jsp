<%@ page language="java" pageEncoding="utf-8"%>


<!DOCTYPE>
<html lang="en">
<head>

	<title>北京邮电大学|系统管理员|部门管理</title>

	<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
	<link rel="stylesheet" href="static/css/reset.css" media="screen">
	<link rel="stylesheet" href="static/css/depManage.css" media="screen">
	<script src="static/js/jquery-2.2.4.js" type="text/javascript"></script>
	<script src="https://unpkg.com/vue@2.2.4/dist/vue.js"></script>
	<script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>

<body>
<div id="container">
	<header>
		<h1>部门管理</h1>
	</header>
	<div id="mainSection">
		<el-dialog title="添加用户" v-model="addUserDialog" size="small">
			<el-form :model="addForm" label-width="80px">
				<el-form-item label="用户"><el-input v-model="addForm.username"></el-input></el-form-item>
				<el-form-item label="昵称"><el-input v-model="addForm.nickname"></el-input></el-form-item>
				<el-form-item label="密码"><el-input v-model="addForm.password"></el-input></el-form-item>
				<el-form-item label="邮箱"><el-input v-model="addForm.email"></el-input></el-form-item>
				<el-form-item label="部门"><el-select v-model="addForm.department" placeholder="请选择部门">
					<el-option  v-for="department in departments" :label="department.label" :value="department.value"></el-option>
				</el-select></el-form-item>
				<el-form-item label="权限"><el-select v-model="addForm.permission" placeholder="请选择权限">
					<el-option  v-for="permission in permissions" :label="permission.label" :value="permission.value"></el-option>
				</el-select></el-form-item>
				<el-form-item>
					<el-button type="primary" @click="onAdd">提交</el-button>
					<el-button @click="onCancel">取消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
		<el-dialog :title="editDialogTitle" v-model="editUserDialog" size="small">
			<el-form :model="editForm" label-width="80px">
				<el-form-item label="部门"><el-select v-model="editForm.department" placeholder="请选择部门">
					<el-option  v-for="department in departments" :label="department.label" :value="department.value"></el-option>
				</el-select></el-form-item>
				<el-form-item label="权限"><el-select v-model="editForm.permission" placeholder="请选择权限">
					<el-option  v-for="permission in permissions" :label="permission.label" :value="permission.value"></el-option>
				</el-select></el-form-item>
				<el-form-item>
					<el-button type="primary" @click="onEdit">提交</el-button>
					<el-button @click="onCancel">取消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
		<el-row><el-col :span="3"><el-button @click="addUserDialog=true" icon="plus">添加</el-button></el-col></el-row>
		<el-row>
			<el-table :data="depData" border>
				<el-table-column prop="depName" label="部门名称" fixed="left" width="120"></el-table-column>
				<el-table-column prop="depId" label="部门参数"></el-table-column>
				<el-table-column prop="depManagerSum" label="部门管理员人数"></el-table-column>
				<el-table-column prop="depTel" label="联系方式"></el-table-column>
				<el-table-column fixed="right" label="操作" width="100">
					<template scope="scope"><el-button-group>
						<el-tooltip class="item" effect="dark" content="修改" placement="top"><el-button type="primary" size="small" icon="edit" @click="editUser(scope.$index, scope.row)"></el-button></el-tooltip>
						<el-tooltip class="item" effect="dark" content="删除" placement="top"><el-button type="danger" size="small" icon="delete" @click="deleteUser(scope.$index, scope.row)"></el-button></el-tooltip>
					</el-button-group></template>
				</el-table-column>
			</el-table>
		</el-row>
		<el-pagination @current-change="handleCurrentChange" :current-page="pagination.currentPage" :page-size="pagination.size" layout="total, prev, pager, next, jumper" :total="pagination.total"></el-pagination>
	</div>
</div>
<script src="static/js/depManage.js" type="text/javascript"></script>
</body>
</html>
