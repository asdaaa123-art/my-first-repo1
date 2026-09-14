<template>
	<div class="center-preview">
		<div class="center-title">{{ title }}</div>
		<div class="center-info">
			<div class="center-info-title">个人信息</div>
			<div class="img-box" v-if="userTableName=='juanzengzhe'">
				<img :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')">
			</div>
			<div class="info-item1" v-if="userTableName=='juanzengzhe'">
				<span class="icon iconfont "></span>
				<div class="label">捐赠者账号：</div>
				<div class="text">{{sessionForm.juanzengzhezhanghao}}</div>
			</div>
			<div class="info-item2" v-if="userTableName=='juanzengzhe'">
				<span class="icon iconfont "></span>
				<div class="label">捐赠者姓名：</div>
				<div class="text">{{sessionForm.juanzengzhexingming}}</div>
			</div>
			<div class="info-item3" v-if="userTableName=='juanzengzhe'">
				<span class="icon iconfont "></span>
				<div class="label">性别：</div>
				<div class="text">{{sessionForm.xingbie}}</div>
			</div>
			<div class="info-item4" v-if="userTableName=='juanzengzhe'">
				<span class="icon iconfont "></span>
				<div class="label">手机：</div>
				<div class="text">{{sessionForm.shouji}}</div>
			</div>
			<div class="info-item5" v-if="userTableName=='juanzengzhe'">
				<span class="icon iconfont "></span>
				<div class="label">邮箱：</div>
				<div class="text">{{sessionForm.youxiang}}</div>
			</div>
			<div class="info-item6" v-if="userTableName=='juanzengzhe'">
				<span class="icon iconfont "></span>
				<div class="label">身份证：</div>
				<div class="text">{{sessionForm.shenfenzheng}}</div>
			</div>
			<div class="info-item1" v-if="userTableName=='shouzhuzhe'">
				<span class="icon iconfont "></span>
				<div class="label">受助者账号：</div>
				<div class="text">{{sessionForm.shouzhuzhezhanghao}}</div>
			</div>
			<div class="info-item2" v-if="userTableName=='shouzhuzhe'">
				<span class="icon iconfont "></span>
				<div class="label">受助者姓名：</div>
				<div class="text">{{sessionForm.shouzhuzhexingming}}</div>
			</div>
			<div class="info-item3" v-if="userTableName=='shouzhuzhe'">
				<span class="icon iconfont "></span>
				<div class="label">性别：</div>
				<div class="text">{{sessionForm.xingbie}}</div>
			</div>
			<div class="info-item4" v-if="userTableName=='shouzhuzhe'">
				<span class="icon iconfont "></span>
				<div class="label">手机：</div>
				<div class="text">{{sessionForm.shouji}}</div>
			</div>
			<div class="info-item5" v-if="userTableName=='shouzhuzhe'">
				<span class="icon iconfont "></span>
				<div class="label">邮箱：</div>
				<div class="text">{{sessionForm.youxiang}}</div>
			</div>
			<div class="info-item6" v-if="userTableName=='shouzhuzhe'">
				<span class="icon iconfont "></span>
				<div class="label">身份证：</div>
				<div class="text">{{sessionForm.shenfenzheng}}</div>
			</div>
			<div class="info-item1" v-if="userTableName=='zhiyuanzhe'">
				<span class="icon iconfont "></span>
				<div class="label">志愿者账号：</div>
				<div class="text">{{sessionForm.zhiyuanzhezhanghao}}</div>
			</div>
			<div class="info-item2" v-if="userTableName=='zhiyuanzhe'">
				<span class="icon iconfont "></span>
				<div class="label">志愿者姓名：</div>
				<div class="text">{{sessionForm.zhiyuanzhexingming}}</div>
			</div>
			<div class="info-item3" v-if="userTableName=='zhiyuanzhe'">
				<span class="icon iconfont "></span>
				<div class="label">性别：</div>
				<div class="text">{{sessionForm.xingbie}}</div>
			</div>
			<div class="info-item4" v-if="userTableName=='zhiyuanzhe'">
				<span class="icon iconfont "></span>
				<div class="label">手机：</div>
				<div class="text">{{sessionForm.shouji}}</div>
			</div>
		
		</div>
	
		<el-tabs class="center-tabs" tab-position="left" @tab-click="handleClick">
			<el-tab-pane label="个人中心">
				<el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="180px">
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="捐赠者账号" prop="juanzengzhezhanghao">
						<el-input v-model="sessionForm.juanzengzhezhanghao" placeholder="捐赠者账号" readonly></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="捐赠者姓名" prop="juanzengzhexingming">
						<el-input v-model="sessionForm.juanzengzhexingming" placeholder="捐赠者姓名" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="性别" prop="xingbie">
						<el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
							<el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="手机" prop="shouji">
						<el-input v-model="sessionForm.shouji" placeholder="手机" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="邮箱" prop="youxiang">
						<el-input v-model="sessionForm.youxiang" placeholder="邮箱" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="身份证" prop="shenfenzheng">
						<el-input v-model="sessionForm.shenfenzheng" placeholder="身份证" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='juanzengzhe'" label="头像" prop="touxiang">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
							@change="juanzengzhetouxiangHandleAvatarSuccess"
							></file-upload>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="受助者账号" prop="shouzhuzhezhanghao">
						<el-input v-model="sessionForm.shouzhuzhezhanghao" placeholder="受助者账号" readonly></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="受助者姓名" prop="shouzhuzhexingming">
						<el-input v-model="sessionForm.shouzhuzhexingming" placeholder="受助者姓名" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="性别" prop="xingbie">
						<el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
							<el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="手机" prop="shouji">
						<el-input v-model="sessionForm.shouji" placeholder="手机" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="邮箱" prop="youxiang">
						<el-input v-model="sessionForm.youxiang" placeholder="邮箱" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="身份证" prop="shenfenzheng">
						<el-input v-model="sessionForm.shenfenzheng" placeholder="身份证" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='shouzhuzhe'" label="头像" prop="touxiang">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
							@change="shouzhuzhetouxiangHandleAvatarSuccess"
							></file-upload>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='zhiyuanzhe'" label="志愿者账号" prop="zhiyuanzhezhanghao">
						<el-input v-model="sessionForm.zhiyuanzhezhanghao" placeholder="志愿者账号" readonly></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='zhiyuanzhe'" label="志愿者姓名" prop="zhiyuanzhexingming">
						<el-input v-model="sessionForm.zhiyuanzhexingming" placeholder="志愿者姓名" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='zhiyuanzhe'" label="性别" prop="xingbie">
						<el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
							<el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='zhiyuanzhe'" label="手机" prop="shouji">
						<el-input v-model="sessionForm.shouji" placeholder="手机" ></el-input>
					</el-form-item>
					<el-form-item class="center-item" v-if="userTableName=='zhiyuanzhe'" label="头像" prop="touxiang">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
							@change="zhiyuanzhetouxiangHandleAvatarSuccess"
							></file-upload>
					</el-form-item>
					<el-form-item class="center-btn-item">
						<div class="updateBtn" type="primary" @click="onSubmit('sessionForm')">
							<span class="icon iconfont icon-kaitongfuwu"></span>
							<span class="text">更新信息</span>
						</div>
						<div class="closeBtn" type="danger" @click="logout">
							<span class="icon iconfont icon-shanchu1"></span>
							<span class="text">退出登录</span>
						</div>
					</el-form-item>
				</el-form>
			</el-tab-pane>
			<el-tab-pane label="修改密码">
				<el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules" label-width="180px">
					<el-form-item class="center-item" label="原密码" prop="password">
						<el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
					</el-form-item>
					<el-form-item class="center-item" label="新密码" prop="newpassword">
						<el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
					</el-form-item>
					<el-form-item class="center-item" label="确认密码" prop="repassword">
						<el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
					</el-form-item>
					<el-form-item class="center-btn-item">
						<div class="updateBtn" type="primary" @click="updatePassword">
							<span class="icon iconfont icon-kaitongfuwu"></span>
							<span class="text">修改密码</span>
						</div>
					</el-form-item>
				</el-form>
			</el-tab-pane>
			<el-tab-pane label="聊天记录" style="width: 100%;" v-if="changeHasChat()">
				<div class="z-box">
					<div class="section-content" v-for="item in recordList" :key="item.id" @click.stop="chatClick(item)">
						<div class="chat-left">
							<img :src="item.picture?baseUrl + item.picture:require('@/assets/avator.png')">
							<div class="chat-info">
								<div class="chat-name">{{item.name}}</div>
								<div class="chat-text">
									<div class="chat-noread" v-if="item.notreadnum">{{item.notreadnum}}</div>
									{{item.content.split('/').length>1&&item.content.split('/')[0]=='upload'?'[图片]':item.content}}
								</div>
							</div>
						</div>
						<div class="chat-btn">
							<div class="friendBtn2" @click.stop="chatDel(item)">删除</div>
						</div>
					</div>
					<div class="noList" v-if="!recordList.length">
						暂无聊天记录
					</div>
				</div>
			
			</el-tab-pane>
			<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
			<el-tab-pane label="我的收藏"></el-tab-pane>
		</el-tabs>

		<el-dialog :visible.sync="chatVisible" @close="clearChat" :title="nowname">
			<div class="chat-content" id="chat-content">
				<div v-bind:key="item.id" v-for="item in chatList">
					<div v-if="item.addtime" class="addtime">{{timeFormat(item.addtime)}}</div>
					<div v-if="item.uid==sessionForm.id" class="right-content">
						<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
							type="warning"></el-alert>
						<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
						<img :src="mypic?baseUrl + mypic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 0 0 10px;" />
					</div>
					<div v-else class="left-content">
						<img :src="nowfpic?baseUrl + nowfpic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 10px 0 0;" />
						<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
							type="success"></el-alert>
						<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
					</div>
					<div class="clear-float"></div>
				</div>
			</div>
			<div slot="footer" class="dialog-footer">
				<el-input @keydown.enter.native="addChat(null)" v-model="chatForm.content" placeholder="请输入内容" style="width: calc(100% - 180px);float: left;">
				</el-input>
				<el-button :disabled="chatForm.content?false:true" type="primary" @click="addChat(null)">发送</el-button>
				<el-upload style="display: inline-block;margin: 0 0 0 6px;" class="upload-demo" :action="uploadUrl" :on-success="uploadSuccess"
					:show-file-list="false">
					<el-button type="success">上传图片</el-button>
				</el-upload>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import config from '@/config/config';
	import menu from '@/config/menu';
	import Vue from 'vue';
	import timeMethod from '@/common/timeMethod'
	import {
		WebsocketMixin
	} from '@/mixins/WebsocketMixin'
	export default {
		mixins: [WebsocketMixin],
		//数据集合
		data() {
			return {
				title: '个人中心',
				baseUrl: config.baseUrl,
				sessionForm: {},
				passwordForm: {},
				passwordRules: {
					password: [
						{
							required: true,
							message: "密码不能为空",
							trigger: "blur"
						}
					],
					newpassword: [
						{
							required: true,
							message: "新密码不能为空",
							trigger: "blur"
						}
					],
					repassword: [
						{
							required: true,
							message: "确认密码不能为空",
							trigger: "blur"
						}
					]
				},
				rules: {},
				menuList: [],
				disabled: false,
				uploadUrl: config.baseUrl + 'file/upload',
				imageUrl: '',
				headers: {Token: localStorage.getItem('frontToken')},
				userTableName: localStorage.getItem('UserTableName'),
				dynamicProp: {},
				recordList: [],
				chatVisible: false,
				nowfid: 0,
				nowfpic:'',
				nowname: '',
				mypic: localStorage.getItem('frontHeadportrait'),
				chatList: [],
				chatForm: {
					content: ''
				},
				hasChatList: [
					'juanzengzhe',
					'shouzhuzhe',
					'zhiyuanzhe',
					'kefurenyuan',
					'juanzengwupinshenqing',
					'juanzengjilu',
				],
			}
		},
		created() {
			let menus = menu.list()
			for(let x in menus){
				if(menus[x].tableName == this.userTableName){
					for(let i in menus[x].backMenu){
						if(menus[x].backMenu[i].menu=='考试管理'){
							menus[x].backMenu.splice(i,1)
						}
					}
					this.menuList = menus[x].backMenu
				}
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'juanzengzhezhanghao', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'mima', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'juanzengzhexingming', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'xingbie', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shouji', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'youxiang', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shenfenzheng', null);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'touxiang', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shouzhuzhezhanghao', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'mima', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shouzhuzhexingming', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'xingbie', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shouji', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'youxiang', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shenfenzheng', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'touxiang', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'sfsh', null);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shhf', null);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'zhiyuanzhezhanghao', null);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'zhiyuanzhexingming', null);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'mima', null);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'xingbie', null);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'shouji', null);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.sessionForm, 'touxiang', null);
			}

			if ('juanzengzhe' == this.userTableName&&this.rules['juanzengzhezhanghao']){
				this.rules['juanzengzhezhanghao'].push({ required: true, message: '请输入捐赠者账号', trigger: 'blur' })
			}else if('juanzengzhe' == this.userTableName&&!this.rules['juanzengzhezhanghao']) {
				this.$set(this.rules, 'juanzengzhezhanghao', [{ required: true, message: '请输入捐赠者账号', trigger: 'blur' }]);
			}
			if ('juanzengzhe' == this.userTableName&&this.rules['mima']){
				this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
			}else if('juanzengzhe' == this.userTableName&&!this.rules['mima']) {
				this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
			}
			if ('juanzengzhe' == this.userTableName) {
				this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
			}
			if ('shouzhuzhe' == this.userTableName&&this.rules['shouzhuzhezhanghao']){
				this.rules['shouzhuzhezhanghao'].push({ required: true, message: '请输入受助者账号', trigger: 'blur' })
			}else if('shouzhuzhe' == this.userTableName&&!this.rules['shouzhuzhezhanghao']) {
				this.$set(this.rules, 'shouzhuzhezhanghao', [{ required: true, message: '请输入受助者账号', trigger: 'blur' }]);
			}
			if ('shouzhuzhe' == this.userTableName&&this.rules['mima']){
				this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
			}else if('shouzhuzhe' == this.userTableName&&!this.rules['mima']) {
				this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
			}
			if ('shouzhuzhe' == this.userTableName) {
				this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
			}
			if ('zhiyuanzhe' == this.userTableName&&this.rules['zhiyuanzhezhanghao']){
				this.rules['zhiyuanzhezhanghao'].push({ required: true, message: '请输入志愿者账号', trigger: 'blur' })
			}else if('zhiyuanzhe' == this.userTableName&&!this.rules['zhiyuanzhezhanghao']) {
				this.$set(this.rules, 'zhiyuanzhezhanghao', [{ required: true, message: '请输入志愿者账号', trigger: 'blur' }]);
			}
			if ('zhiyuanzhe' == this.userTableName&&this.rules['zhiyuanzhexingming']){
				this.rules['zhiyuanzhexingming'].push({ required: true, message: '请输入志愿者姓名', trigger: 'blur' })
			}else if('zhiyuanzhe' == this.userTableName&&!this.rules['zhiyuanzhexingming']) {
				this.$set(this.rules, 'zhiyuanzhexingming', [{ required: true, message: '请输入志愿者姓名', trigger: 'blur' }]);
			}
			if ('zhiyuanzhe' == this.userTableName&&this.rules['mima']){
				this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
			}else if('zhiyuanzhe' == this.userTableName&&!this.rules['mima']) {
				this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
			}
			if ('zhiyuanzhe' == this.userTableName) {
				this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
			}

			this.init();
			this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
		},
		//方法集合
		methods: {
			init() {
				if ('juanzengzhe' == this.userTableName) {
					this.dynamicProp.xingbie = '男,女'.split(',');
				}
				if ('shouzhuzhe' == this.userTableName) {
					this.dynamicProp.xingbie = '男,女'.split(',');
				}
				if ('zhiyuanzhe' == this.userTableName) {
					this.dynamicProp.xingbie = '男,女'.split(',');
				}
			},
			setSession(){
				localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
			},
			onSubmit(formName) {
				if(`juanzengzhe` == this.userTableName && this.sessionForm.touxiang!=null){
					this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
				}
				if(`shouzhuzhe` == this.userTableName && this.sessionForm.touxiang!=null){
					this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
				}
				if(`zhiyuanzhe` == this.userTableName && this.sessionForm.touxiang!=null){
					this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
				}
				this.$refs[formName].validate((valid) => {
					if (valid) {
						this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
							if (res.data.code == 0) {
								this.setSession()
								this.$message({
									message: '更新成功',
									type: 'success',
									duration: 1500
								});
							}
						});
					} else {
						return false;
					}
				});
			},
			juanzengzhetouxiangHandleAvatarSuccess(fileUrls) {
				this.sessionForm.touxiang = fileUrls;
			},
			shouzhuzhetouxiangHandleAvatarSuccess(fileUrls) {
				this.sessionForm.touxiang = fileUrls;
			},
			zhiyuanzhetouxiangHandleAvatarSuccess(fileUrls) {
				this.sessionForm.touxiang = fileUrls;
			},
			handleClick(tab, event) {
				switch(event.target.outerText) {
					case '个人中心':
						tab.$router.push('/index/center');
						break;
					case '修改密码':
						this.passwordForm = {
							password: '',
							newpassword: '',
							repassword: '',
						}
						this.$forceUpdate()
						break;
					case '聊天记录':
						this.getRecordList()
						break;
					case '我的收藏':
						localStorage.setItem('storeupType', 1);
						tab.$router.push('/index/storeup');
						break;
					default:
						tab.$router.push(`/index/${tab.name}?centerType=1`);
				}

				this.title = event.target.outerText;
			},
			changeHasChat(){
				let table = localStorage.getItem('frontSessionTable')
				for(let x in this.hasChatList){
					if(this.hasChatList[x]==table){
						return true
					}
				}
				return false
			},
			getRecordList() {
				this.$http.get('friend/page2', {
					params: {
						uid: Number(localStorage.getItem('frontUserid')),
						type: 2
					}
				}).then(res => {
					if (res.data && res.data.code == 0) {
						this.recordList = res.data.data.list
					}
				})
			},
			chatClick(row) {
				this.nowfid = row.fid
				this.nowfpic = row.picture
				this.nowname = row.name
				this.initWebSocket(this.nowfid)
				this.getChatList()
				this.chatVisible = true
			},
			chatDel(row){
				this.$confirm('是否删除聊天记录？').then(_ => {
					let arr = []
					let brr = []
					this.$http.get('chatmessage/list',{params: {
						page: 1,
						limit: 10000,
						uid: Number(localStorage.getItem('frontUserid')),
						fid: row.fid
					}}).then(rs=>{
						if(rs.data.data.list.length){
							for(let x in rs.data.data.list){
								arr.push(rs.data.data.list[x].id)
							}
						}
						this.$http.get('chatmessage/list',{params: {
							page: 1,
							limit: 10000,
							uid: row.fid,
							fid: Number(localStorage.getItem('frontUserid'))
						}}).then(rs2=>{
							if(rs2.data.data.list.length){
								for(let x in rs2.data.data.list){
									arr.push(rs2.data.data.list[x].id)
								}
							}
							if(arr.length){
								this.$http.post('chatmessage/delete',arr).then(()=>{})
							}
							this.$http.get('friend/list',{params: {
								page: 1,
								limit: 10000,
								uid: row.fid,
								fid: Number(localStorage.getItem('frontUserid')),
								type: 0
							}}).then(rs3=>{
								if(rs3.data.data.list.length){
									for(let x in rs3.data.data.list){
										brr.push(rs3.data.data.list[x].id)
									}
								}
								this.$http.get('friend/list',{params: {
									page: 1,
									limit: 10000,
									fid: row.fid,
									uid: Number(localStorage.getItem('frontUserid')),
									type: 0
								}}).then(rs4=>{
									if(rs4.data.data.list.length){
										for(let x in rs4.data.data.list){
											brr.push(rs4.data.data.list[x].id)
										}
									}
									this.$http.get('friend/list',{params: {
										page: 1,
										limit: 10000,
										fid: row.fid,
										uid: Number(localStorage.getItem('frontUserid')),
										type: 2
									}}).then(rs5=>{
										if(rs5.data.data.list.length){
											for(let x in rs5.data.data.list){
												brr.push(rs5.data.data.list[x].id)
											}
										}
										this.$http.get('friend/list',{params: {
											page: 1,
											limit: 10000,
											uid: row.fid,
											fid: Number(localStorage.getItem('frontUserid')),
											type: 2
										}}).then(rs6=>{
											if(rs6.data.data.list.length){
												for(let x in rs6.data.data.list){
													brr.push(rs6.data.data.list[x].id)
												}
											}
											this.$http.post('friend/delete',brr).then(()=>{
												this.$message.success('删除成功')
												this.getRecordList()
											})
										})
									})
								})
							})
						})
					})
				}).catch(_ => {});
			},
			websocketOnopen: function() {
				
			},
			websocketOnmessage:function(e) {
				this.getChatList()
			},
			getChatList() {
				this.$http.get('chatmessage/mlist', {
					params: {
						page: 1,
						limit: 1000,
						uid: Number(localStorage.getItem('frontUserid')),
						fid: this.nowfid
					}
				}).then(res => {
					if (res.data && res.data.code == 0) {
						this.chatList = this.formatMessages(res.data.data.list)
						let div = document.getElementsByClassName('chat-content')[0]
						setTimeout(() => {
							if (div)
								div.scrollTop = div.scrollHeight
						}, 0)
					}
				})
			},
			formatMessages(messages) {
				let lastTime = null;
				messages.forEach((message, index) => {
					const currentTime = new Date(message.addtime).getTime();
					if (lastTime !== null) {
						const timeDiff = (currentTime - lastTime) / 1000 / 60; // 转换为分钟
						if (timeDiff < 3) {
							message.addtime = ''; // 如果小于3分钟，不显示时间
						}
					}
					lastTime = currentTime;
				});
				return messages;
			},
			timeFormat(time) {
				const Time = timeMethod.getTime(time).split("T");
				//当前消息日期属于周
				const week = timeMethod.getDateToWeek(time);
				//当前日期0时
				const nti = timeMethod.setTimeZero(timeMethod.getNowTime());
				//消息日期当天0时
				const mnti = timeMethod.setTimeZero(timeMethod.getTime(time));
				//计算日期差值
				const diffDate = timeMethod.calculateTime(nti, mnti);
				//本周一日期0时 （后面+1是去除当天时间）
				const fwnti = timeMethod.setTimeZero(timeMethod.countDateStr(-timeMethod.getDateToWeek(timeMethod
					.getNowTime()).weekID + 1));
				//计算周日期差值
				const diffWeek = timeMethod.calculateTime(mnti, fwnti);

				if (diffDate === 0) { //消息发送日期减去当天日期如果等于0则是当天时间
					return Time[1].slice(0, 5);
				} else if (diffDate < 172800000) { //当前日期减去消息发送日期小于2天（172800000ms）则是昨天-  一天最大差值前天凌晨00:00:00到今天晚上23:59:59
					return "昨天 " + Time[1].slice(0, 5);
				} else if (diffWeek >= 0) { //消息日期减去本周一日期大于0则是本周
					return week.weekName;
				} else { //其他时间则是日期
					return Time[0].slice(5, 10);
				}
			},
			clearChat(){
				this.websocketOnclose();
				this.chatList = []
				this.getRecordList()
			},
			uploadSuccess(res) {
				if (res.code == 0) {
					this.addChat('upload/' + res.file);
				}
			},
			addChat(ask=null) {
				this.$http.post('chatmessage/add', {
					uid: Number(localStorage.getItem('frontUserid')),
					fid: this.nowfid,
					content: ask?ask:this.chatForm.content,
					format: ask?2:1
				}).then(res2 => {
					this.websocketSend(ask?ask:this.chatForm.content)
					this.chatForm = {
						content: ''
					}
					this.getChatList()
				})
			},
			async updatePassword(){
				this.$refs["passwordForm"].validate(async valid => {
					if (valid) {
						var password = "";
						if (this.sessionForm.mima) {
							password = this.sessionForm.mima;
						} else if (this.sessionForm.password) {
							password = this.sessionForm.password;
						}
						if (this.userTableName == 'juanzengzhe') {
						}
						if (this.userTableName == 'shouzhuzhe') {
						}
						if (this.userTableName == 'zhiyuanzhe') {
						}
						if (this.passwordForm.password != password) {
							this.$message.error("原密码错误");
							return;
						}
						if (this.passwordForm.newpassword != this.passwordForm.repassword) {
							this.$message.error("两次密码输入不一致");
							return;
						}
						if (this.passwordForm.newpassword == this.passwordForm.password) {
							this.$message.error("新密码与原密码相同！");
							return;
						}
						this.sessionForm.password = this.passwordForm.newpassword;
						this.sessionForm.mima = this.passwordForm.newpassword;
						this.$http.post(`${this.userTableName}/update`,this.sessionForm).then(({data})=>{
							if (data && data.code === 0) {
								this.$message({
									message: "修改密码成功,下次登录系统生效",
									type: "success",
									duration: 1500,
									onClose: () => {
									}
								});
								this.setSession()
							} else {
								this.$message.error(data.msg);
							}
						});
					}
				})
			},
			logout() {
				localStorage.clear();
				Vue.http.headers.common['Token'] = "";
				this.$router.push('/index/home');
				this.activeIndex = '0'
				localStorage.setItem('keyPath', this.activeIndex)
				this.$forceUpdate()
				this.$message({
					message: '登出成功',
					type: 'success',
					duration: 1500,
				});
			},
			hasBack(name){
				switch(name){
					case '我的收藏管理':
						return false
						break;
					default:
						return true
				}
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.center-preview {
		margin: 10px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.center-title {
			margin: 10px 0;
			color: #333;
			background: #f7db61;
			width: 100%;
			font-size: 24px;
			line-height: 50px;
			border-bottom: 1px solid #1f292f;
			text-align: center;
		}
		.center-info {
			border-radius: 10px;
			padding: 30px 0;
			box-shadow: none;
			margin: 20px auto;
			background: #ffffff;
			display: flex;
			width: 100%;
			line-height: 2;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			height: auto;
			.center-info-title {
				color: #333;
				width: 100%;
				font-size: 20px;
				border-color: #efefef;
				border-width: 1px;
				line-height: 44px;
				border-style: solid;
				text-align: center;
				height: 44px;
			}
			.img-box {
				display: inline-block;
				width: auto;
				font-size: 0;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				border-style: solid;
				height: auto;
				img {
					border-radius: 100%;
					margin: 20px auto 0;
					object-fit: cover;
					display: block;
					width: 80px;
					border-color: #efefef;
					border-width: 0 0 1px 0;
					border-style: solid;
					height: 80px;
				}
			}
			.info-item1 {
				padding: 0 20px;
				display: inline-block;
				width: auto;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				line-height: inherit;
				border-style: solid;
				height: auto;
				.icon {
					padding: 0 5px;
					color: inherit;
					font-size: inherit;
				}
				.label {
					color: inherit;
					font-weight: 600;
					font-size: inherit;
				}
				.text {
					color: inherit;
					flex: 1;
					font-size: inherit;
					text-align: right;
				}
			}
			.info-item2 {
				padding: 0 20px;
				display: inline-block;
				width: auto;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				line-height: inherit;
				border-style: solid;
				height: auto;
				.icon {
					padding: 0 5px;
					color: inherit;
					font-size: inherit;
				}
				.label {
					color: inherit;
					font-weight: 600;
					font-size: inherit;
				}
				.text {
					color: inherit;
					flex: 1;
					font-size: inherit;
					text-align: right;
				}
			}
			.info-item3 {
				padding: 0 20px;
				display: inline-block;
				width: auto;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				line-height: inherit;
				border-style: solid;
				height: auto;
				.icon {
					padding: 0 5px;
					color: inherit;
					font-size: inherit;
				}
				.label {
					color: inherit;
					font-weight: 600;
					font-size: inherit;
				}
				.text {
					color: inherit;
					flex: 1;
					font-size: inherit;
					text-align: right;
				}
			}
			.info-item4 {
				padding: 0 20px;
				display: inline-block;
				width: auto;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				line-height: inherit;
				border-style: solid;
				height: auto;
				.icon {
					padding: 0 5px;
					color: inherit;
					font-size: inherit;
				}
				.label {
					color: inherit;
					font-weight: 600;
					font-size: inherit;
				}
				.text {
					color: inherit;
					flex: 1;
					font-size: inherit;
					text-align: right;
				}
			}
			.info-item5 {
				padding: 0 20px;
				display: inline-block;
				width: auto;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				line-height: inherit;
				border-style: solid;
				height: auto;
				.icon {
					padding: 0 5px;
					color: inherit;
					font-size: inherit;
				}
				.label {
					color: inherit;
					font-weight: 600;
					font-size: inherit;
				}
				.text {
					color: inherit;
					flex: 1;
					font-size: inherit;
					text-align: right;
				}
			}
			.info-item6 {
				padding: 0 20px;
				display: inline-block;
				width: auto;
				border-color: #efefef;
				border-width: 0 0 0px 0;
				line-height: inherit;
				border-style: solid;
				height: auto;
				.icon {
					padding: 0 5px;
					color: inherit;
					font-size: inherit;
				}
				.label {
					color: inherit;
					font-weight: 600;
					font-size: inherit;
				}
				.text {
					color: inherit;
					flex: 1;
					font-size: inherit;
					text-align: right;
				}
			}
		}
		.center-tabs.el-tabs {
			background: none;
			width: 100%;
			/deep/ .el-tabs__header {
				padding: 10px 10px 0;
				margin: 0 0 20px;
				background: #f7db6130;
				width: 100%;
				clear: both;
				border-color: #f7db6150;
				border-width: 2px;
				position: relative;
				border-style: inset;
				text-align: center;
			}
			/deep/ .el-tabs__header .el-tabs__item {
				padding: 0 10px;
				margin: 0 10px 10px 0;
				color: #333;
				font-weight: 500;
				display: block;
				font-size: inherit;
				line-height: 36px;
				float: left;
				border-radius: 4px;
				background: #ffffff;
				position: relative;
				text-align: center;
				height: 36px;
			}
			/deep/ .el-tabs__header .el-tabs__item:hover {
				padding: 0 10px;
				color: #333;
				background: #f7db6199;
				font-weight: 500;
				font-size: inherit;
				line-height: 36px;
				position: relative;
				text-align: center;
				height: 36px;
			}
			/deep/ .el-tabs__header .el-tabs__item.is-active {
				padding: 0 10px;
				margin: 0 10px 10px 0;
				color: #333;
				font-weight: 500;
				display: block;
				font-size: inherit;
				line-height: 36px;
				float: left;
				border-radius: 4px;
				background: #f7db6199;
				position: relative;
				text-align: center;
				height: 36px;
			}
			/deep/ .el-tabs__content {
				padding: 0;
				background: none;
				width: 100%;
				clear: both;
			}
			/deep/ .el-tabs__content .el-tab-pane {
				background: none;
				width: 100%;
			}
			& /deep/ .el-tabs__header {
				.el-tabs__nav{
					overflow: auto;
				}
				::-webkit-scrollbar {
					-webkit-appearance: none;
					width: 6px;
					height: 6px;
				}
				::-webkit-scrollbar-track {
					background: rgba(0, 0, 0, 0.1);
					border-radius: 0;
				}
				::-webkit-scrollbar-thumb {
					cursor: pointer;
					border-radius: 5px;
					background: rgba(0, 0, 0, 0.15);
					transition: color 0.2s ease;
				}
				::-webkit-scrollbar-thumb:hover {
					background: rgba(0, 0, 0, 0.3);
				}
				.el-tabs__nav-wrap {
					margin: 0;
					&::after {
						content: none;
					}
				}
				.el-tabs__active-bar {
					display: none !important;
				}
			}
			.center-preview-pv {
				.center-item.el-form-item {
					border: 2px inset #f7db6150;
					padding: 10px;
					margin: 0 0 10px;
					background: #f7db6110;
					/deep/ .el-form-item__label {
						padding: 0 10px 0 0;
						color: inherit;
						font-weight: 500;
						width: 180px;
						font-size: inherit;
						line-height: 40px;
						text-align: right;
					}
					.el-form-item__content {
						margin-left: 180px;
					}
					.el-input {
						width: 100%;
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
						color: inherit;
						background: none;
						width: auto;
						font-size: 16px;
						height: 40px;
					}
					.el-select {
						width: auto;
					}
					.el-select /deep/ .el-input__inner {
						border: 1px solid #ddd;
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: none;
						color: inherit;
						width: auto;
						font-size: 16px;
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
						width: auto;
						font-size: 16px;
						height: 40px;
					}
					.el-date-editor {
						width: 100%;
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
						font-size: 32px;
						line-height: 80px;
						text-align: center;
						height: 80px;
					}
					/deep/ .el-upload-list .el-upload-list__item {
						border: 1px solid #ddd;
						cursor: pointer;
						border-radius: 0px;
						color: #999;
						background: #fff;
						width: 80px;
						font-size: 32px;
						line-height: 80px;
						text-align: center;
						height: 80px;
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
						font-size: 32px;
						line-height: 80px;
						text-align: center;
						height: 80px;
					}
					/deep/ .el-upload__tip {
						color: #838fa1;
						font-size: 16px;
					}
					/deep/ .el-input__inner::placeholder {
						color: #999;
						font-size: inherit;
					}
				}
				.center-btn-item {
					padding: 0;
					margin: 20px 0;
					.updateBtn {
						border: 0;
						cursor: pointer;
						border-radius: 2px;
						padding: 0 15px;
						margin: 0 20px 0 0;
						background: #f7db61;
						display: inline-block;
						width: auto;
						font-size: 16px;
						line-height: 40px;
						height: 40px;
						.icon {
							color: #333;
						}
						.text {
							color: #333;
						}
					}
					.updateBtn:hover {
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
				.el-date-editor.el-input {
					width: auto;
				}
			}
		}
	}
	.z-box {
		padding: 0px;
		margin: 0 auto;
		display: flex;
		width: 100%;
		justify-content: space-between;
		flex-wrap: wrap;
		.section-content {
			cursor: pointer;
			padding: 20px;
			margin: 0 0 20px;
			color: #333;
			display: flex;
			border-color: #ddd;
			box-shadow: none;
			background: #fff;
			width: calc(50% - 10px);
			justify-content: space-between;
			border-width: 1px;
			align-items: center;
			position: relative;
			border-style: solid;
			.chat-left {
				display: flex;
				align-items: center;
				img {
					border-radius: 50%;
					width: 60px;
					transition: all .4s;
					height: 60px;
				}
				.chat-info {
					margin: 0 0 0 10px;
					flex-direction: column;
					display: flex;
					align-items: flex-start;
					.chat-name {
						color: #888;
						flex: 1;
						font-weight: bold;
						font-size: 14px;
						transition: all .4s;
					}
					.chat-text {
						color: #888;
						flex: 1;
						display: flex;
						font-size: 12px;
						line-height: 1.5;
						align-items: center;
						transition: all .4s;
						.chat-noread {
							border-radius: 50%;
							padding: 0 5px;
							margin: 0 2px 0 0;
							color: #fff;
							background: #f00;
							width: auto;
							font-size: 12px;
							line-height: 16px;
							text-align: center;
							height: 16px;
						}
					}
				}
			}
			.chat-btn {
				flex-direction: column;
				display: flex;
				.friendBtn1 {
					padding: 0px 10px;
					margin: 0px;
					color: #fff;
					background: rgba(75, 223, 201,1);
					text-decoration: none;
					width: 80px;
					font-size: 12px;
					line-height: 30px;
					text-align: center;
					height: 30px;
				}
				.friendBtn1:hover {
					background: rgba(75, 223, 201,.5);
				}
				.friendBtn2 {
					padding: 0px 10px;
					margin: 0px;
					color: #fff;
					background: rgba(255, 85, 0, 1.0);
					text-decoration: none;
					width: 80px;
					font-size: 12px;
					line-height: 30px;
					text-align: center;
					height: 30px;
				}
				.friendBtn2:hover {
					background: rgba(255, 85, 0, 0.5);
				}
			}
		}
		.section-content:hover {
			color: #fff;
			background: #f7db6110;
			.chat-left {
				img {
					border-radius: 5px;
				}
				.chat-info {
					.chat-name {
						color: #000;
					}
					.chat-text {
						color: #000;
						font-size: 13px;
					}
				}
			}
		}
	}
	.chat-content {
		padding-bottom: 20px;
		width: 100%;
		margin-bottom: 10px;
		max-height: 300px;
		height: 300px;
		overflow-y: scroll;
		border: 1px solid #eeeeee;
		background: #fff;
	
		.addtime {
			width: 100%;
			text-align: center;
			font-size: 12px;
		}
	
		.left-content {
			float: left;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	
		.right-content {
			float: right;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	}
	
	.clear-float {
		clear: both;
	}
	.noList {
		color: #9e9e9e;
		width: 100%;
		text-align: center;
		padding: 60px 0;
	}
</style>
