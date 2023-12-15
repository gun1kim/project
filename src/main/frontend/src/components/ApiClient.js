import axios from "axios";

const ApiClient = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Authorization': `Bearer ${localStorage.getItem('access-token')}`
    }
});

ApiClient.interceptors.response.use(
    function (response) {
        return response;
    },
    function (error) {
        const originalRequest = error.config
    ;
    if (error.response.status === 401 && !originalRequest._retry) {
        originalRequest._retry = true;
        // return axios.post('/member/reissue',)
        return axios.post('http://localhost:8080/api/member/reissue', {
            accessToken: localStorage.getItem('access-token'),
            refreshToken: localStorage.getItem('refresh-token')
        }, { 
            headers: {
                'Authorization': 'Bearer ' + localStorage.getItem('access-token'),
                'x-refresh-token': localStorage.getItem('refresh-token')
        }})
        .then(res => {
            if (res.status === 200) {
                localStorage.setItem('access-token', res.data.accessToken);
                originalRequest.headers['Authorization'] = 'Bearer ' + res.data.accessToken;
                return axios(originalRequest);
            }
        });
        }
        return Promise.reject(error);
    }
)

export default ApiClient;