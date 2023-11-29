import React from "react";
import "./GatheringList.css";
import {useState, useEffect} from "react";
import axios from "axios";

function GatheringList() {

    const [lists, setLists] = useState([]);
    const [show, setShow] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/gathering');
                setLists(response.data);
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching data from API:', error);
            }
        }
        fetchData();
    }, []);

    useEffect(() => {
        console.log(lists);

    }, [lists])


    return (
        <div className="gathering-index">
            <div className="div">
                <header className="header">
                    <div className="header-logo-wrap">
                        <div className="logo-wrap">
                            <div className="ellipse" />
                            <div className="ECO-CONNECT">
                                ECO
                                <br />
                                CONNECT
                            </div>
                            <img
                                className="icon-leaf"
                                alt="Icon leaf"
                                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/---icon--leaf-@2x.png"
                            />
                        </div>
                    </div>
                    <div className="header-menu-wrap">
                        <div className="header-mission-wrap">
                            <div className="text-wrapper">봉사미션</div>
                        </div>
                        <div className="div-wrapper">
                            <div className="text-wrapper">봉사모임</div>
                        </div>
                        <div className="div-wrapper">
                            <div className="text-wrapper">펀딩</div>
                        </div>
                        <div className="div-wrapper">
                            <div className="text-wrapper">고객지원</div>
                        </div>
                    </div>
                    <img
                        className="header-icon-wrap"
                        alt="Header icon wrap"
                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656756a4f1ba10802eac0624/img/header-icon-wrap.svg"
                    />
                </header>
            </div>
            <div className="div">
                <div className="card-info">
                    <div className="card-info-text-big">
                        <p className="p">
                            똑같은 봉사라도 더 다채롭게 <br />
                            만들어 줄 원데이 취향 모임
                        </p>
                    </div>
                    <div className="card-info-text-small">
                        <p className="card-info-text-small-2">
                            누구나 열고 참여할 수 있는 원데이모임,
                            <br />
                            소셜링으로 가볍고 즐겁게 만나보세요!
                        </p>
                    </div>
                </div>
            </div>
            <div className="middle-menu-wrap">
                <div className="middle-menu-total">
                    <div className="middle-menu-total-2">전체</div>
                </div>
                <div className="div-2">
                    <div className="middle-menu-clean" />
                    <div className="middle-menu-clean-wrapper">
                        <div className="middle-menu-clean-2">환경미화</div>
                    </div>
                </div>
                <div className="div-2">
                    <div className="middle-menu-talent" />
                    <div className="div-wrapper-2">
                        <div className="text-wrapper-2">재능기부</div>
                    </div>
                </div>
                <div className="div-2">
                    <div className="middle-menu-donation" />
                    <div className="div-wrapper-2">
                        <div className="text-wrapper-2">기부모임</div>
                    </div>
                </div>
                <div className="middle-menu-blank" />
                <div className="middle-menu-search">
                    <div className="search-icon-wrapper">
                        <img
                            className="search-icon"
                            alt="Search icon"
                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/search-icon@2x.png"
                        />
                    </div>
                </div>
            </div>
            <div className="gathering-banner">
                <img
                    className="img"
                    alt="Gathering banner"
                    src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/65673b953ef9bbba272aaf86/img/gathering-banner-image.png"
                />
            </div>

            <div className="gathering-list-wrap">
                {lists.map((item, index) => (
                    <div className="gathering-list">
                        <div className="gathering-list-2">
                            <div className="gathering-list-image" />
                            <div className="gathering-list-info">
                                <div className="gathering-list-title">
                                    <div className="gathering-list-title-2">{item.title}</div>
                                </div>
                                <div className="gathering-list-sum">
                                    {item.content}
                                    {/*<div className="gathering-list-sum-2">{item.content}</div>*/}
                                </div>
                                <div className="gathering-list-3">
                                    <img
                                        className="gathering-list-4"
                                        alt="Gathering list"
                                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"
                                    />
                                    <div className="gathering-list-5">
                                        <img
                                            className="gathering-list-6"
                                            alt="Gathering list"
                                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"
                                        />
                                        <div className="gathering-list-7">
                                            <div className="text-wrapper-3">{item.count}/{item.capacity}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                ))}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*    <div className="gathering-list">*/}
            {/*        <div className="gathering-list-2">*/}
            {/*            <div className="gathering-list-image" />*/}
            {/*            <div className="gathering-list-info">*/}
            {/*                <div className="gathering-list-title">*/}
            {/*                    <div className="gathering-list-title-2">오리역 봉사모임 입니다!</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-sum">*/}
            {/*                    <div className="gathering-list-sum-2">단기모임 / 11.26(일) 하루만</div>*/}
            {/*                </div>*/}
            {/*                <div className="gathering-list-3">*/}
            {/*                    <img*/}
            {/*                        className="gathering-list-4"*/}
            {/*                        alt="Gathering list"*/}
            {/*                        src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/frame-427318306.svg"*/}
            {/*                    />*/}
            {/*                    <div className="gathering-list-5">*/}
            {/*                        <img*/}
            {/*                            className="gathering-list-6"*/}
            {/*                            alt="Gathering list"*/}
            {/*                            src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/group@2x.png"*/}
            {/*                        />*/}
            {/*                        <div className="gathering-list-7">*/}
            {/*                            <div className="text-wrapper-3">14/20</div>*/}
            {/*                        </div>*/}
            {/*                    </div>*/}
            {/*                </div>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </div>*/}
            {/*</div>*/}
            <div className="gathering-list-8">
                <div className="pagination-button">
                    <div className="pagination-left-wrap">
                        <div className="pagination-left">
                            <img
                                className="img-2"
                                alt="Double left"
                                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/double-left@2x.png"
                            />
                        </div>
                    </div>
                    <div className="pagination">
                        <div className="text-wrapper-4">1</div>
                    </div>
                    <div className="pagination-num">
                        <div className="element">2</div>
                    </div>
                    <div className="pagination">
                        <div className="text-wrapper-4">3</div>
                    </div>
                    <div className="pagination">
                        <div className="text-wrapper-4">4</div>
                    </div>
                    <div className="pagination">
                        <div className="text-wrapper-4">5</div>
                    </div>
                    <div className="pagination-right">
                        <div className="double-right-wrapper">
                            <img
                                className="img-2"
                                alt="Double right"
                                src="https://cdn.animaapp.com/projects/6560b21274de9042f7d947f4/releases/656753efcb8de04689f6bb1b/img/double-right@2x.png"
                            />
                        </div>
                    </div>
                </div>
                <div className="register-button-wrap">
                    <div className="register-button">
                        <div className="register-text">작성</div>
                    </div>
                </div>
            </div>
            <div className="footer-wrap">
                <div className="footer-logo-wrap">
                    <div className="footer-image-wrap" />
                </div>
                <div className="footer-menu-wrap">
                    <div className="div-wrapper-3">
                        <div className="text-wrapper-5">이용안내</div>
                    </div>
                    <div className="div-wrapper-3">
                        <div className="text-wrapper-5">공지사항</div>
                    </div>
                    <div className="div-wrapper-3">
                        <div className="text-wrapper-5">Q&amp;A</div>
                    </div>
                    <div className="div-wrapper-3">
                        <div className="text-wrapper-5">이용약관</div>
                    </div>
                    <div className="footer-privacy-wrap">
                        <p className="footer-privacy">개인정보 수집 및 이용 동의</p>
                    </div>
                </div>
                <div className="footer-inquiry-wrap">
                    <div className="footer-inquiry">문의하기</div>
                </div>
                <div className="footer-button-wrap">
                    <div className="footer-button">
                        <div className="footer-button-text">바로가기</div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    )
}


export default GatheringList;