<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__bounceIn" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">爱心小屋捐赠系统的设计与实现</div>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.juanzengzhezhanghao"  autocomplete="off" placeholder="捐赠者账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.juanzengzhexingming"  autocomplete="off" placeholder="捐赠者姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in juanzengzhexingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<el-input  v-model="ruleForm.shenfenzheng"  autocomplete="off" placeholder="身份证"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="juanzengzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.shouzhuzhezhanghao"  autocomplete="off" placeholder="受助者账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.shouzhuzhexingming"  autocomplete="off" placeholder="受助者姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in shouzhuzhexingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<el-input  v-model="ruleForm.shenfenzheng"  autocomplete="off" placeholder="身份证"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="shouzhuzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<el-input  v-model="ruleForm.zhiyuanzhezhanghao"  autocomplete="off" placeholder="志愿者账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<el-input  v-model="ruleForm.zhiyuanzhexingming"  autocomplete="off" placeholder="志愿者姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in zhiyuanzhexingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="zhiyuanzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<el-input  v-model="ruleForm.kefuzhanghao"  autocomplete="off" placeholder="客服账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<el-input  v-model="ruleForm.kefuxingming"  autocomplete="off" placeholder="客服姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in kefurenyuanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="kefurenyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            juanzengzhexingbieOptions: [],
            shouzhuzhexingbieOptions: [],
            zhiyuanzhexingbieOptions: [],
            kefurenyuanxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='juanzengzhe'){
				this.ruleForm = {
					juanzengzhezhanghao: '',
					mima: '',
					juanzengzhexingming: '',
					xingbie: '',
					shouji: '',
					youxiang: '',
					shenfenzheng: '',
					touxiang: '',
				}
			}
			if(this.tableName=='shouzhuzhe'){
				this.ruleForm = {
					shouzhuzhezhanghao: '',
					mima: '',
					shouzhuzhexingming: '',
					xingbie: '',
					shouji: '',
					youxiang: '',
					shenfenzheng: '',
					touxiang: '',
					sfsh: '',
					shhf: '',
				}
			}
			if(this.tableName=='zhiyuanzhe'){
				this.ruleForm = {
					zhiyuanzhezhanghao: '',
					zhiyuanzhexingming: '',
					mima: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='kefurenyuan'){
				this.ruleForm = {
					kefuzhanghao: '',
					mima: '',
					kefuxingming: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if ('juanzengzhe' == this.tableName) {
				this.rules.juanzengzhezhanghao = [{ required: true, message: '请输入捐赠者账号', trigger: 'blur' }]
			}
			if ('juanzengzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shouzhuzhe' == this.tableName) {
				this.rules.shouzhuzhezhanghao = [{ required: true, message: '请输入受助者账号', trigger: 'blur' }]
			}
			if ('shouzhuzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.zhiyuanzhezhanghao = [{ required: true, message: '请输入志愿者账号', trigger: 'blur' }]
			}
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.zhiyuanzhexingming = [{ required: true, message: '请输入志愿者姓名', trigger: 'blur' }]
			}
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kefurenyuan' == this.tableName) {
				this.rules.kefuzhanghao = [{ required: true, message: '请输入客服账号', trigger: 'blur' }]
			}
			if ('kefurenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kefurenyuan' == this.tableName) {
				this.rules.kefuxingming = [{ required: true, message: '请输入客服姓名', trigger: 'blur' }]
			}
			this.juanzengzhexingbieOptions = "男,女".split(',')
			this.shouzhuzhexingbieOptions = "男,女".split(',')
			this.zhiyuanzhexingbieOptions = "男,女".split(',')
			this.kefurenyuanxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        juanzengzhetouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        shouzhuzhetouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        zhiyuanzhetouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        kefurenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.juanzengzhezhanghao) && `juanzengzhe` == this.tableName){
				this.$message.error(`捐赠者账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `juanzengzhe` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `juanzengzhe` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`juanzengzhe` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			  if(this.tableName=='shouzhuzhe'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.shouzhuzhezhanghao) && `shouzhuzhe` == this.tableName){
				this.$message.error(`受助者账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `shouzhuzhe` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `shouzhuzhe` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`shouzhuzhe` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.zhiyuanzhezhanghao) && `zhiyuanzhe` == this.tableName){
				this.$message.error(`志愿者账号不能为空`);
				return
			}
			if((!this.ruleForm.zhiyuanzhexingming) && `zhiyuanzhe` == this.tableName){
				this.$message.error(`志愿者姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `zhiyuanzhe` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `zhiyuanzhe` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`zhiyuanzhe` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.kefuzhanghao) && `kefurenyuan` == this.tableName){
				this.$message.error(`客服账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `kefurenyuan` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `kefurenyuan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.kefuxingming) && `kefurenyuan` == this.tableName){
				this.$message.error(`客服姓名不能为空`);
				return
			}
			if(`kefurenyuan` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240908/d034b47ed098416a8fa2a89d739cf12f.jpg) no-repeat center center / 100% 100%;
	background: url(http://codegen.caihongy.cn/20240908/d034b47ed098416a8fa2a89d739cf12f.jpg) no-repeat center center / 100% 100%;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	position: relative !important;
	.rgs-form {
		.rgs-form2 {
		width: 100%;
		}
		border-radius: 30px;
		padding: 30px 80px 30px 80px;
		margin: 20px auto 60px;
		background: #0B0B0B80;
		width: 600px;
		height: auto;
		.title {
			padding: 0;
			margin: 0 0 20px 0;
			color: #fff;
			background: none;
			font-weight: 600;
			width: auto;
			font-size: 26px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 40px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px 0 30px;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px 0 30px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				border-width: 1px 1px 1px 10px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				border-width: 1px 1px 1px 10px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: none;
				width: 90px;
				font-size: 24px;
				border-width: 1px 1px 1px 10px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #aaa;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				top: 5px;
				left: 136px;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				margin: 0;
				color: #666;
				background: none;
				flex: 1;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			input:focus {
				border: 1px solid #e6e6e6;
				border-radius: 8px;
				padding: 0 10px;
				outline: none;
				color: #e6e6e6;
				background: none;
				width: 100%;
				font-size: 15px;
				border-width: 1px 1px 1px 10px;
				height: 38px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #e6e6e6;
				cursor: pointer;
				border-radius: 8px;
				padding: 0;
				margin: 0 0 0 10px;
				color: #fff;
				background: #FCBB78;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.9;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			font-weight: 600;
			letter-spacing: 10px;
			font-size: 22px;
			border-radius: 8px;
			background: #FCBB78;
			width: 100%;
			min-width: 68px;
			height: 50px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.9;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #aaa;
			display: inline-block;
			width: 100%;
			font-size: 15px;
			line-height: 40px;
			text-align: right;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
