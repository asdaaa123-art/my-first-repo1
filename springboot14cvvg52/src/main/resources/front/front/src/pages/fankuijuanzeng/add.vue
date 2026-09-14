<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="捐赠编号" prop="juanzengbianhao">
				<el-input v-model="ruleForm.juanzengbianhao" 
					placeholder="捐赠编号" clearable :disabled=" false  ||ro.juanzengbianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="受助者账号" prop="shouzhuzhezhanghao">
				<el-input v-model="ruleForm.shouzhuzhezhanghao" 
					placeholder="受助者账号" clearable :disabled=" false  ||ro.shouzhuzhezhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="受助者姓名" prop="shouzhuzhexingming">
				<el-input v-model="ruleForm.shouzhuzhexingming" 
					placeholder="受助者姓名" clearable :disabled=" false  ||ro.shouzhuzhexingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="头像" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
				<file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
					@change="touxiangUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="头像" prop="touxiang">
				<img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="捐赠者账号" prop="juanzengzhezhanghao">
				<el-input v-model="ruleForm.juanzengzhezhanghao" 
					placeholder="捐赠者账号" clearable :disabled=" false  ||ro.juanzengzhezhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="捐赠者姓名" prop="juanzengzhexingming">
				<el-input v-model="ruleForm.juanzengzhexingming" 
					placeholder="捐赠者姓名" clearable :disabled=" false  ||ro.juanzengzhexingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="收到物品清单" prop="shoudaowupinqingdan">
				<el-input v-model="ruleForm.shoudaowupinqingdan" 
					placeholder="收到物品清单" clearable :disabled=" false  ||ro.shoudaowupinqingdan"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="发布时间" prop="fabushijian">
				<el-date-picker
					:disabled=" false  ||ro.fabushijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.fabushijian" 
					type="datetime"
					placeholder="发布时间">
				</el-date-picker>
			</el-form-item>
			<el-form-item class="add-item" label="感想" prop="ganxiang">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="感想"
					v-model="ruleForm.ganxiang">
					</el-input>
			</el-form-item>
			<el-form-item class="add-item" label="评价" prop="pingjia">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="评价"
					v-model="ruleForm.pingjia">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-kaitongfuwu"></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu1"></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					juanzengbianhao : false,
					shouzhuzhezhanghao : false,
					shouzhuzhexingming : false,
					touxiang : false,
					juanzengzhezhanghao : false,
					juanzengzhexingming : false,
					shoudaowupinqingdan : false,
					ganxiang : false,
					pingjia : false,
					fabushijian : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					juanzengbianhao: '',
					shouzhuzhezhanghao: '',
					shouzhuzhexingming: '',
					touxiang: '',
					juanzengzhezhanghao: '',
					juanzengzhexingming: '',
					shoudaowupinqingdan: '',
					ganxiang: '',
					pingjia: '',
					fabushijian: '',
				},


				rules: {
					juanzengbianhao: [
					],
					shouzhuzhezhanghao: [
					],
					shouzhuzhexingming: [
					],
					touxiang: [
					],
					juanzengzhezhanghao: [
					],
					juanzengzhexingming: [
					],
					shoudaowupinqingdan: [
					],
					ganxiang: [
					],
					pingjia: [
					],
					fabushijian: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.fabushijian = this.getCurDateTime()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='juanzengbianhao'){
							this.ruleForm.juanzengbianhao = obj[o];
							this.ro.juanzengbianhao = true;
							continue;
						}
						if(o=='shouzhuzhezhanghao'){
							this.ruleForm.shouzhuzhezhanghao = obj[o];
							this.ro.shouzhuzhezhanghao = true;
							continue;
						}
						if(o=='shouzhuzhexingming'){
							this.ruleForm.shouzhuzhexingming = obj[o];
							this.ro.shouzhuzhexingming = true;
							continue;
						}
						if(o=='touxiang'){
							this.ruleForm.touxiang = obj[o]?obj[o].split(",")[0]:'';
							this.ro.touxiang = true;
							continue;
						}
						if(o=='juanzengzhezhanghao'){
							this.ruleForm.juanzengzhezhanghao = obj[o];
							this.ro.juanzengzhezhanghao = true;
							continue;
						}
						if(o=='juanzengzhexingming'){
							this.ruleForm.juanzengzhexingming = obj[o];
							this.ro.juanzengzhexingming = true;
							continue;
						}
						if(o=='shoudaowupinqingdan'){
							this.ruleForm.shoudaowupinqingdan = obj[o];
							this.ro.shoudaowupinqingdan = true;
							continue;
						}
						if(o=='ganxiang'){
							this.ruleForm.ganxiang = obj[o];
							this.ro.ganxiang = true;
							continue;
						}
						if(o=='pingjia'){
							this.ruleForm.pingjia = obj[o];
							this.ro.pingjia = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.shouzhuzhezhanghao!=''&&json.shouzhuzhezhanghao) || json.shouzhuzhezhanghao==0){
							this.ruleForm.shouzhuzhezhanghao = json.shouzhuzhezhanghao;
							this.ro.shouzhuzhezhanghao = true;
						}
						if((json.shouzhuzhexingming!=''&&json.shouzhuzhexingming) || json.shouzhuzhexingming==0){
							this.ruleForm.shouzhuzhexingming = json.shouzhuzhexingming;
							this.ro.shouzhuzhexingming = true;
						}
						if((json.touxiang!=''&&json.touxiang) || json.touxiang==0){
							this.ruleForm.touxiang = json.touxiang;
							this.ro.touxiang = true;
						}
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`fankuijuanzeng/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`fankuijuanzeng/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			touxiangUploadChange(fileUrls) {
				this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border: 2px inset #f7db6150;
				padding: 10px;
				margin: 0 0 10px;
				background: #f7db6110;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #f7db61;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
					background: #f7db6199;
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 0px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
					background: #eee;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 2px;
					background: #f7db61;
					width: auto;
					text-align: center;
					min-width: 110px;
					height: 40px;
					.icon {
						color: #333;
					}
					.text {
						color: #333;
					}
				}
				.submitBtn:hover {
					opacity: 0.8;
					.icon {
						color: #000;
					}
					.text {
						color: #000;
					}
				}
				.closeBtn {
					border: 1px solid #ddd;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 2px;
					background: #fff;
					width: auto;
					text-align: center;
					min-width: 110px;
					height: 40px;
					.icon {
						color: #666;
					}
					.text {
						color: #666;
					}
				}
				.closeBtn:hover {
					background: #f7db61;
					border-color: #f7db61;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
