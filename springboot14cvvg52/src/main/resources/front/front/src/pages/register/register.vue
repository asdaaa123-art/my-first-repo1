<template>
	<div>
		<div id="particles"></div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">爱心小屋捐赠系统的设计与实现</p></div>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="juanzengzhezhanghao">
						<div class="label" :class="changeRules('juanzengzhezhanghao')?'required':''">捐赠者账号：</div>
						<el-input v-model="registerForm.juanzengzhezhanghao"  placeholder="请输入捐赠者账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="juanzengzhexingming">
						<div class="label" :class="changeRules('juanzengzhexingming')?'required':''">捐赠者姓名：</div>
						<el-input v-model="registerForm.juanzengzhexingming"  placeholder="请输入捐赠者姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in juanzengzhexingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="youxiang">
						<div class="label" :class="changeRules('youxiang')?'required':''">邮箱：</div>
						<el-input v-model="registerForm.youxiang"  placeholder="请输入邮箱" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="shenfenzheng">
						<div class="label" :class="changeRules('shenfenzheng')?'required':''">身份证：</div>
						<el-input v-model="registerForm.shenfenzheng"  placeholder="请输入身份证" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='juanzengzhe'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="juanzengzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="shouzhuzhezhanghao">
						<div class="label" :class="changeRules('shouzhuzhezhanghao')?'required':''">受助者账号：</div>
						<el-input v-model="registerForm.shouzhuzhezhanghao"  placeholder="请输入受助者账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="shouzhuzhexingming">
						<div class="label" :class="changeRules('shouzhuzhexingming')?'required':''">受助者姓名：</div>
						<el-input v-model="registerForm.shouzhuzhexingming"  placeholder="请输入受助者姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in shouzhuzhexingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="youxiang">
						<div class="label" :class="changeRules('youxiang')?'required':''">邮箱：</div>
						<el-input v-model="registerForm.youxiang"  placeholder="请输入邮箱" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="shenfenzheng">
						<div class="label" :class="changeRules('shenfenzheng')?'required':''">身份证：</div>
						<el-input v-model="registerForm.shenfenzheng"  placeholder="请输入身份证" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='shouzhuzhe'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="shouzhuzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="zhiyuanzhezhanghao">
						<div class="label" :class="changeRules('zhiyuanzhezhanghao')?'required':''">志愿者账号：</div>
						<el-input v-model="registerForm.zhiyuanzhezhanghao"  placeholder="请输入志愿者账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="zhiyuanzhexingming">
						<div class="label" :class="changeRules('zhiyuanzhexingming')?'required':''">志愿者姓名：</div>
						<el-input v-model="registerForm.zhiyuanzhexingming"  placeholder="请输入志愿者姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in zhiyuanzhexingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='zhiyuanzhe'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="zhiyuanzhetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="kefuzhanghao">
						<div class="label" :class="changeRules('kefuzhanghao')?'required':''">客服账号：</div>
						<el-input v-model="registerForm.kefuzhanghao"  placeholder="请输入客服账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="kefuxingming">
						<div class="label" :class="changeRules('kefuxingming')?'required':''">客服姓名：</div>
						<el-input v-model="registerForm.kefuxingming"  placeholder="请输入客服姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in kefurenyuanxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='kefurenyuan'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="kefurenyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';
	require('@/common/particles.js')

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            juanzengzhexingbieOptions: [],
            shouzhuzhexingbieOptions: [],
            zhiyuanzhexingbieOptions: [],
            kefurenyuanxingbieOptions: [],
			particlesJson: {"retina_detect":true,"particles":{"number":{"density":{"value_area":800,"enable":true},"value":160},"move":{"straight":false,"random":true,"bounce":false,"enable":true,"attract":{"rotateX":600,"enable":false,"rotateY":600},"speed":1,"direction":"none","out_mode":"out"},"color":{"value":"#ff0"},"shape":{"image":{"width":100,"src":"img/github.svg","height":100},"polygon":{"nb_sides":5},"type":"circle","stroke":{"color":"#000000","width":0}},"size":{"anim":{"size_min":0.3,"sync":false,"enable":false,"speed":4},"random":true,"value":3},"line_linked":{"width":1,"distance":150,"color":"#ffffff","opacity":0.4,"enable":false},"opacity":{"anim":{"opacity_min":0,"sync":false,"enable":true,"speed":1},"random":true,"value":1}},"interactivity":{"detect_on":"canvas","events":{"resize":true,"onclick":{"mode":"repulse","enable":true},"onhover":{"mode":"bubble","enable":true}},"modes":{"grab":{"distance":400,"line_linked":{"opacity":1}},"bubble":{"duration":2,"distance":250,"size":0,"opacity":0,"speed":3},"repulse":{"duration":0.4,"distance":400},"push":{"particles_nb":4},"remove":{"particles_nb":2}}}}
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='juanzengzhe'){
				this.registerForm = {
					juanzengzhezhanghao: '',
					mima: '',
					mima2: '',
					juanzengzhexingming: '',
					xingbie: '',
					shouji: '',
					youxiang: '',
					shenfenzheng: '',
					touxiang: '',
				}
			}
			if(this.tableName=='shouzhuzhe'){
				this.registerForm = {
					shouzhuzhezhanghao: '',
					mima: '',
					mima2: '',
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
				this.registerForm = {
					zhiyuanzhezhanghao: '',
					zhiyuanzhexingming: '',
					mima: '',
					mima2: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='kefurenyuan'){
				this.registerForm = {
					kefuzhanghao: '',
					mima: '',
					mima2: '',
					kefuxingming: '',
					xingbie: '',
					shouji: '',
					touxiang: '',
				}
			}
			if ('juanzengzhe' == this.tableName) {
				this.rules.juanzengzhezhanghao = [{ required: true, message: '请输入捐赠者账号', trigger: 'blur' }];
				this.requiredRules.juanzengzhezhanghao = [{ required: true, message: '请输入捐赠者账号', trigger: 'blur' }]
			}
			if ('juanzengzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.juanzengzhexingbieOptions = "男,女".split(',');
			if ('juanzengzhe' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('shouzhuzhe' == this.tableName) {
				this.rules.shouzhuzhezhanghao = [{ required: true, message: '请输入受助者账号', trigger: 'blur' }];
				this.requiredRules.shouzhuzhezhanghao = [{ required: true, message: '请输入受助者账号', trigger: 'blur' }]
			}
			if ('shouzhuzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.shouzhuzhexingbieOptions = "男,女".split(',');
			if ('shouzhuzhe' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.zhiyuanzhezhanghao = [{ required: true, message: '请输入志愿者账号', trigger: 'blur' }];
				this.requiredRules.zhiyuanzhezhanghao = [{ required: true, message: '请输入志愿者账号', trigger: 'blur' }]
			}
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.zhiyuanzhexingming = [{ required: true, message: '请输入志愿者姓名', trigger: 'blur' }];
				this.requiredRules.zhiyuanzhexingming = [{ required: true, message: '请输入志愿者姓名', trigger: 'blur' }]
			}
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.zhiyuanzhexingbieOptions = "男,女".split(',');
			if ('zhiyuanzhe' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('kefurenyuan' == this.tableName) {
				this.rules.kefuzhanghao = [{ required: true, message: '请输入客服账号', trigger: 'blur' }];
				this.requiredRules.kefuzhanghao = [{ required: true, message: '请输入客服账号', trigger: 'blur' }]
			}
			if ('kefurenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kefurenyuan' == this.tableName) {
				this.rules.kefuxingming = [{ required: true, message: '请输入客服姓名', trigger: 'blur' }];
				this.requiredRules.kefuxingming = [{ required: true, message: '请输入客服姓名', trigger: 'blur' }]
			}
			this.kefurenyuanxingbieOptions = "男,女".split(',');
			if ('kefurenyuan' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
		}
		particlesJS('particles',this.particlesJson);
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		juanzengzhetouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		shouzhuzhetouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		zhiyuanzhetouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		kefurenyuantouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(`juanzengzhe` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(this.tableName=='shouzhuzhe'){
						this.registerForm.sfsh = '待审核'
					}
					if(`shouzhuzhe` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`zhiyuanzhe` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`kefurenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background-repeat: no-repeat;
		background-size: 100% 100%!important;
		background: url(http://codegen.caihongy.cn/20240813/defbbf2e1be3426099c7bb1d3c1aec60.jpg);
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		background-position: center center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20240813/defbbf2e1be3426099c7bb1d3c1aec60.jpg);
		.rgs-form {
			padding: 0;
			margin: 0;
			z-index: 10;
			background: url(http://codegen.caihongy.cn/20240813/2496a696e7bc428dad680ba393445caa.png) no-repeat center center / 100% 100%;
			display: flex;
			width: 100%;
			min-height: 100vh;
			justify-content: flex-start;
			align-items: center;
			height: auto;
			.rgs-form2 {
				padding: 0;
				margin: 0 0 0 10%;
				background: none;
				width: 550px;
				.title {
					margin: 0 0 20px 0;
					color: #333;
					width: 100%;
					font-size: 24px;
					line-height: 44px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					margin: 0 auto 25px;
					width: 100%;
					position: relative;
					/deep/.el-form-item__content {
						padding: 0 0 0 120px;
						display: block;
						width: 100%;
						.label {
							padding: 0 5px 0 0;
							z-index: 99;
							color: #333;
							left: 0;
							width: 120px;
							font-size: 16px;
							line-height: 40px;
							position: absolute !important;
							text-align: right;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							margin: 3px 10px 0 0;
							color: red;
							left: 110px;
							position: inherit;
							content: "*";
						}
						.el-input {
							flex: 1;
							width: 100%;
						}
						.el-input .el-input__inner {
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input .el-input__inner:focus {
							border: 1px solid #f7db61;
							border-radius: 0;
							padding: 0 10px;
							outline: none;
							color: #666;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input-number {
							flex: 1;
							width: 100%;
						}
						.el-input-number .el-input__inner {
							text-align: left;
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input-number .el-input-number__decrease {
							display: none;
						}
						.el-input-number .el-input-number__increase {
							display: none;
						}
						.el-select {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-select .el-input__inner {
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-select .el-input__inner:focus {
							border: 1px solid #f7db61;
							border-radius: 0;
							padding: 0 10px;
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-date-editor {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-date-editor .el-input__inner {
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px 0 30px;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-date-editor .el-input__inner:focus {
							border: 1px solid #f7db61;
							border-radius: 0;
							padding: 0 10px 0 30px;
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							color: #999;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 80px;
							text-align: center;
							height: 80px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							color: #999;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 80px;
							text-align: center;
							height: 80px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							color: #999;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 80px;
							text-align: center;
							height: 80px;
						}
						.el-upload__tip {
							color: #666;
							font-size: 15px;
						}
						.emailInput {
							border: 1px solid #ddd;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							margin: 0;
							color: #606266;
							background: #fff;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.emailInput:focus {
							border: 1px solid #f7db61;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							outline: none;
							color: #606266;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-btn {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0 0px 0px 0;
							padding: 0 10px;
							margin: 0;
							color: #333;
							background: #f5f5f5;
							width: 110px;
							font-size: 15px;
							height: 40px;
						}
						.el-btn:hover {
							opacity: 0.8;
						}
						
						.el-input__inner::placeholder {
							color: #999;
							font-size: 15px;
						}
						input::placeholder {
							color: #999;
							font-size: 15px;
						}
						.editor {
							margin: 0;
							background: #fff;
							width: calc(100% - 0px);
							height: auto;
						}
					}
				}
				.register-btn {
					margin: 20px auto;
					width: 100%;
				}
				.register-btn1 {
					padding: 0 0 0 120px;
					width: 100%;
				}
				.register-btn2 {
					padding: 0 0 0 120px;
					margin: 0 auto 15px;
					width: 100%;
					text-align: right;
				}
				.register_btn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 30px;
					margin: 0 0px;
					color: #000;
					background: #f7db61;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.register_btn:hover {
					opacity: 0.8;
				}
				.has_btn {
					cursor: pointer;
					padding: 0;
					color: #555;
					display: inline-block;
					text-decoration: none;
					font-size: 15px;
					line-height: 40px;
				}
				.has_btn:hover {
					opacity: 0.8;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	#particles{
		background-repeat: no-repeat;
		z-index: 9;
		background-size: cover;
		width: 100%;
		position: absolute;
		background-position: 50% 50%;
		height: 100%;
	}
	::-webkit-scrollbar {
		display: none;
	}
</style>
