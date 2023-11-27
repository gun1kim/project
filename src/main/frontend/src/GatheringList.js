import React from "react";
import "./GatheringList.css";
import "./Root.css";
import { useState, useEffect } from "react";
import axios from "axios";

function GatheringList() {

    const [list, setList] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/gathering');
                setList(response.data);
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching data from API:', error);
            }
        }
        fetchData();
    },[]);

    useEffect(() => {
        console.log(list);
    }, [list])

    return (
        <div className="screen">
            <div className="wrapper">
                <div className="view">
                    <div className="overlap">
                        <div className="overlap-group-wrapper">
                            <div className="overlap-group">
                                <img className="group" src="img/group-254.png" />
                                <div className="text-wrapper">봉사미션</div>
                                <div className="div">봉사모임</div>
                                <div className="text-wrapper-2">펀딩</div>
                                <div className="text-wrapper-3">고객지원</div>
                                <img className="vector" src="img/vector.svg" />
                                <img className="icon-bell" src="img/icon-bell.png" />
                            </div>
                        </div>
                        <div className="element">
                            <div className="icon-leaf-wrapper"><img className="icon-leaf" src="img/icon-leaf.png" /></div>
                            <div className="ECO-CONNECT">ECO<br />CONNECT</div>
                        </div>
                    </div>
                </div>
                <div className="frame">
                    <p className="p">똑같은 봉사라도 더 다채롭게 <br />만들어 줄 원데이 취향 모임</p>
                    <p className="text-wrapper-4">누구나 열고 참여할 수 있는 원데이모임,<br />소셜링으로 가볍고 즐겁게 만나보세요!</p>
                </div>
                <div className="frame-2">
                    <div className="frame-3">
                        <div className="text-wrapper-5">전체</div>
                        <img className="free-icon-waste" src="img/free-icon-waste-7867450-1.png" />
                        <div className="text-wrapper-6">환경미화</div>
                        <img className="free-icon-volunteer" src="img/free-icon-volunteer-4742664-1.png" />
                        <div className="text-wrapper-7">재능기부</div>
                        <img className="img" src="img/free-icon-volunteer-779917-1.png" />
                        <div className="text-wrapper-8">기부모임</div>
                    </div>
                    <div className="header-wrapper">
                        <header className="header">
                            <div className="input">
                                <div className="overlap-group-2">
                                    <input className="search-here" placeholder="Search Here" type="text" />
                                    <img className="search" src="img/search.png" />
                                </div>
                            </div>
                        </header>
                    </div>
                </div>
                <img className="line" src="img/line-37.svg" />
                <div className="view-wrapper">
                    <div className="div-2">
                        <div className="overlap-2">
                            <img className="nature" src="img/nature-3289812-1920-2.png" />
                            <div className="div-3"></div>
                            <div className="discover">
                                <div className="div-2">
                                    <p className="text-wrapper-9">
                                        소규모 모임부터 봉사 모임까지 주변 사람들과 모여서 봉사활동을 시작하세요!
                                    </p>
                                    <div className="div-3"></div>
                                    <div className="text-wrapper-10">미션을 시작해 보세요!</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="frame-4">
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-8.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled-19.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-10.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-12.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-2.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-17.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group-7.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-7.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled-37.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-9.png" />
                                <img className="icon-profile-circled-2" src="img/image.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-24.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-5.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group-6.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-2.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled-36.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-13.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-31.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-4.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-11.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-4.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled-25.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-6.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-30.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-21.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-28.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group-8.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-3.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled-39.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-22.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-3.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-7.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-32.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group-5.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-6.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled-38.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-18.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-14.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-8.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-15.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group-2.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img className="icon-profile-circled" src="img/icon-profile-circled.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-20.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-16.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-29.png" />
                                <img className="icon-profile-circled-2" src="img/icon-profile-circled-26.png" />
                                <div className="frame-8">
                                    <div className="text-wrapper-13">14/20</div>
                                    <img className="icon-group" src="img/icon-group-3.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="frame-5">
                        <div className="nature-wrapper"><img className="nature-2" src="img/nature-3289812-1920-1-5.png" /></div>
                        <div className="frame-6">
                            <div className="text-wrapper-11">오리역 봉사모임 입니다!</div>
                            <div className="text-wrapper-12">단기모임 / 11.26(일) 하루만</div>
                            <div className="frame-7">
                                <img class="icon-profile-circled" src="img/icon-profile-circled-27.png" />
                                <img class="icon-profile-circled-2" src="img/icon-profile-circled-33.png" />
                                <img class="icon-profile-circled-2" src="img/icon-profile-circled-34.png" />
                                <img class="icon-profile-circled-2" src="img/icon-profile-circled-23.png" />
                                <img class="icon-profile-circled-2" src="img/icon-profile-circled-35.png" />
                                <div class="frame-8">
                                    <div class="text-wrapper-13">14/20</div>
                                    <img class="icon-group" src="img/icon-group-4.png" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="frame-9">
                    <div class="frame-10">
                        <img class="img-2" src="img/expand-left-double.svg" />
                        <div class="button-page"><div class="text-wrapper-14">1</div></div>
                        <div class="element-wrapper"><div class="element-2">2</div></div>
                        <div class="button-page"><div class="text-wrapper-14">3</div></div>
                        <div class="button-page"><div class="text-wrapper-14">4</div></div>
                        <div class="button-page"><div class="element-3">5</div></div>
                        <img class="img-2" src="img/expand-right-double.svg" />
                    </div>
                    <div class="btn-row-wrapper">
                        <div class="btn-row">
                            <button class="btn">
                                <div class="div-wrapper"><div class="text-wrapper-15">작성</div></div>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="footer-wrapper">
                    <div class="footer">
                        <div class="button-wrapper">
                            <button class="button"><div class="contact-us">바로가기</div></button>
                        </div>
                        <div class="overlap-group-3">
                            <div class="menu-header-wrapper">
                                <div class="menu-header">
                                    <div class="text-wrapper-16">미용안내</div>
                                    <div class="text-wrapper-16">공지사항</div>
                                    <div class="text-wrapper-16">Q&amp;A</div>
                                    <div class="text-wrapper-16">이용약관</div>
                                    <p class="text-wrapper-16">개인정보 수집 및 이용 동의</p>
                                </div>
                            </div>
                            <img class="frame-11" src="img/frame-427318270.svg" />
                        </div>
                        <div class="image-wrapper"><img class="image" src="img/image-1.png" /></div>
                        <div class="frame-12"><div class="text-wrapper-17">문의하기 —</div></div>
                        <div class="line-wrapper"><img class="line-2" src="img/line-38.svg" /></div>
                    </div>
                </div>
            </div>
        </div>
    )
}


export default GatheringList;