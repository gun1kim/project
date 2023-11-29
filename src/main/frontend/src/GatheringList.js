import React from "react";
import styles from "./GatheringList.module.css";
import styled from "styled-components";
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
        <div className={styles.gatheringList}>
            <div className={styles.gatheringListWrap}>
                <div className={styles.headerWrap}>
                    <div className={styles.header}>
                        <div className={styles.headerProfileWrap}>
                            <img
                                className={styles.profileIcon}
                                alt=""
                                src="/profileicon.svg"
                            />
                        </div>
                        <div className={styles.headerGatheringWrap}>
                            <div className={styles.gathering}>봉사모임</div>
                        </div>
                        <div className={styles.headerFundingWrap}>
                            <div className={styles.gathering}>펀딩</div>
                        </div>
                        <div className={styles.headerSupportWrap}>
                            <div className={styles.gathering}>고객지원</div>
                        </div>
                        <div className={styles.headerMessageIconWrap}>
                            <img
                                className={styles.messageIcon}
                                alt=""
                                src="/messageicon.svg"
                            />
                        </div>
                        <div className={styles.headerAlramIconWrap}>
                            <div className={styles.alramIcon}>
                                <img className={styles.vectorIcon} alt="" src="/vector.svg" />
                                <img className={styles.vectorIcon1} alt="" src="/vector1.svg" />
                            </div>
                        </div>
                        <div className={styles.headerMissionWrap}>
                            <div className={styles.gathering}>봉사미션</div>
                        </div>
                        <div className={styles.headerLogoWrap}>
                            <div className={styles.logoWrap}>
                                <div className={styles.logoWrapChild} />
                                <div className={styles.ecoConnect}>
                                    <p className={styles.eco}>ECO</p>
                                    <p className={styles.eco}>CONNECT</p>
                                </div>
                                <img className={styles.iconLeaf} alt="" src="/-icon-leaf.svg" />
                            </div>
                        </div>
                    </div>
                </div>
                <div className={styles.cardInfoWrap}>
                    <div className={styles.cardInfo}>
                        <img className={styles.cardIcon} alt="" src="/card.svg" />
                    </div>
                    <div className={styles.cardInfoTextBig}>
                        <b className={styles.gathering}>
                            <p className={styles.eco}>{`똑같은 봉사라도 더 다채롭게 `}</p>
                            <p className={styles.eco}>만들어 줄 원데이 취향 모임</p>
                        </b>
                    </div>
                    <div className={styles.cardInfoTextSmall}>
                        <b className={styles.gathering}>
                            <p className={styles.eco}>
                                누구나 열고 참여할 수 있는 원데이모임,
                            </p>
                            <p className={styles.eco}>소셜링으로 가볍고 즐겁게 만나보세요!</p>
                        </b>
                    </div>
                </div>
                <div className={styles.middleMenuWrap}>
                    <div className={styles.middleMenuTotalWrap}>
                        <div className={styles.middleMenuTotalText}>전체</div>
                    </div>
                    <div className={styles.middleMenuCleanWrap}>
                        <div className={styles.middleMenuCleanImageWrap}>
                            <img
                                className={styles.middleMenuCleanImageIcon}
                                alt=""
                                src="/middlemenucleanimage@2x.png"
                            />
                        </div>
                        <div className={styles.middleMenuTotalWrap}>
                            <div className={styles.middleMenuClean}>환경미화</div>
                        </div>
                    </div>
                    <div className={styles.middleMenuCleanWrap}>
                        <div className={styles.middleMenuTotalWrap}>
                            <img
                                className={styles.middleMenuTalentImageIcon}
                                alt=""
                                src="/middlemenutalentimage@2x.png"
                            />
                        </div>
                        <div className={styles.middleMenuTotalWrap}>
                            <div className={styles.middleMenuTalentText}>재능기부</div>
                        </div>
                    </div>
                    <div className={styles.middleMenuTotalWrap}>
                        <div className={styles.middleMenuCleanImageWrap}>
                            <img
                                className={styles.middleMenuDonationIcon}
                                alt=""
                                src="/middlemenudonationicon@2x.png"
                            />
                        </div>
                        <div className={styles.middleMenuTotalWrap}>
                            <div className={styles.middleMenuDonationText}>기부모임</div>
                        </div>
                    </div>
                    <div className={styles.middleMenuCleanImageWrap}>
                        <div className={styles.middleMenuSearch}>
                            <div className={styles.input} />
                            <img
                                className={styles.searchIcon}
                                alt=""
                                src="/searchicon@2x.png"
                            />
                        </div>
                    </div>
                </div>
                <div className={styles.gatheringBannerWrap}>
                    <img
                        className={styles.gatheringBannerImageIcon}
                        alt=""
                        src="/gatheringbannerimage@2x.png"
                    />
                </div>
                <div className={styles.gatheringListWrap1}>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage1@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage1@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage1@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                    <div className={styles.gatheringList1}>
                        <div className={styles.gatheringListBorderWrap}>
                            <div className={styles.gatheringListBorderWrap1} />
                        </div>
                        <div className={styles.gatheringListImageWrap}>
                            <img
                                className={styles.gatheringListImageIcon}
                                alt=""
                                src="/gatheringlistimage1@2x.png"
                            />
                        </div>
                        <div className={styles.gatheringPersonIconWrap}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled1}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled2}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.iconProfileCircled3}>
                            <img className={styles.vectorIcon2} alt="" src="/vector2.svg" />
                            <img className={styles.vectorIcon3} alt="" src="/vector3.svg" />
                            <img className={styles.vectorIcon4} alt="" src="/vector4.svg" />
                        </div>
                        <div className={styles.wrapper}>
                            <div className={styles.div1}>14/20</div>
                        </div>
                        <div className={styles.iconGroup}>
                            <img className={styles.vectorIcon17} alt="" src="/vector5.svg" />
                            <img className={styles.vectorIcon18} alt="" src="/vector6.svg" />
                            <img className={styles.vectorIcon19} alt="" src="/vector7.svg" />
                            <img className={styles.vectorIcon20} alt="" src="/vector8.svg" />
                        </div>
                        <div className={styles.gatheringListTitleWrap}>
                            <div className={styles.gatheringListTitleText}>
                                오리역 봉사모임 입니다!
                            </div>
                        </div>
                        <div className={styles.gatheringListSumWrap}>
                            <div className={styles.gatheringListSumText}>
                                단기모임 / 11.26(일) 하루만
                            </div>
                        </div>
                    </div>
                </div>
                <div className={styles.paginationButtonWrap}>
                    <div className={styles.paginationLeftWrap}>
                        <div className={styles.paginationLeft}>
                            <img
                                className={styles.paginationLeftChild}
                                alt=""
                                src="/vector-9.svg"
                            />
                            <img
                                className={styles.paginationLeftChild}
                                alt=""
                                src="/vector-10.svg"
                            />
                        </div>
                    </div>
                    <div className={styles.paginationNum1}>
                        <div className={styles.div9}>1</div>
                    </div>
                    <div className={styles.paginationNum2}>
                        <div className={styles.div9}>2</div>
                    </div>
                    <div className={styles.paginationNum1}>
                        <div className={styles.div9}>3</div>
                    </div>
                    <div className={styles.paginationNum1}>
                        <div className={styles.div9}>4</div>
                    </div>
                    <div className={styles.paginationNum1}>
                        <div className={styles.div9}>5</div>
                    </div>
                    <div className={styles.paginationRightWrap}>
                        <div className={styles.paginationRight}>
                            <img
                                className={styles.paginationLeftChild}
                                alt=""
                                src="/vector-101.svg"
                            />
                            <img
                                className={styles.paginationLeftChild}
                                alt=""
                                src="/vector-91.svg"
                            />
                        </div>
                    </div>
                </div>
                <div className={styles.registerButtonWrap}>
                    <div className={styles.registerButton}>
                        <div className={styles.registerText}>작성</div>
                    </div>
                </div>
                <div className={styles.footerWrap}>
                    <div className={styles.footer}>
                        <div className={styles.footerLogoWrap}>
                            <div className={styles.footerImageWrap}>
                                <img
                                    className={styles.footerLogoIcon}
                                    alt=""
                                    src="/footerlogo@2x.png"
                                />
                            </div>
                        </div>
                        <div className={styles.footerMenuWrap}>
                            <div className={styles.paginationLeft}>
                                <div className={styles.gathering}>
                                    <p className={styles.eco}>이용안내</p>
                                </div>
                            </div>
                            <div className={styles.paginationLeft}>
                                <div className={styles.gathering}>{`공지사항 `}</div>
                            </div>
                            <div className={styles.paginationLeft}>
                                <div className={styles.gathering}>{`Q&A`}</div>
                            </div>
                            <div className={styles.paginationLeft}>
                                <div className={styles.gathering}>이용약관</div>
                            </div>
                            <div className={styles.paginationLeft}>
                                <div className={styles.gathering}>
                                    개인정보 수집 및 이용 동의
                                </div>
                            </div>
                        </div>
                        <div className={styles.footerInquiryWrap}>
                            <div className={styles.gathering}>{`문의하기  `}</div>
                        </div>
                        <div className={styles.footerButtonWrap}>
                            <div className={styles.footerButton}>
                                <div className={styles.gathering}>바로가기</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}


export default GatheringList;