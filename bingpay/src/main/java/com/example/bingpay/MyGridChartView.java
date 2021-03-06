package com.example.bingpay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
   *
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/4/21
   */

public class MyGridChartView extends View {
     // 测试的模拟数据
     public String test = "[{\"closePrice\":7403.0,\"highPrice\":7403.0,\"lowPrice\":7403.0,\"openPrice\":7403.0,\"time\":1492754400,\"vol\":0.027},{\"closePrice\":7418.0,\"highPrice\":7418.0,\"lowPrice\":7418.0,\"openPrice\":7418.0,\"time\":1492753500,\"vol\":0.84},{\"closePrice\":7418.0,\"highPrice\":7439.99,\"lowPrice\":7418.0,\"openPrice\":7439.99,\"time\":1492752600,\"vol\":2.64},{\"closePrice\":7422.0,\"highPrice\":7443.99,\"lowPrice\":7422.0,\"openPrice\":7443.99,\"time\":1492751700,\"vol\":2.445},{\"closePrice\":7423.0,\"highPrice\":7423.0,\"lowPrice\":7418.0,\"openPrice\":7418.0,\"time\":1492750800,\"vol\":11.204},{\"closePrice\":7422.0,\"highPrice\":7422.0,\"lowPrice\":7418.87,\"openPrice\":7418.87,\"time\":1492749900,\"vol\":5.056},{\"closePrice\":7400.01,\"highPrice\":7447.17,\"lowPrice\":7400.01,\"openPrice\":7447.17,\"time\":1492749000,\"vol\":0.299},{\"closePrice\":7400.01,\"highPrice\":7400.01,\"lowPrice\":7400.0,\"openPrice\":7400.0,\"time\":1492748100,\"vol\":8.617},{\"closePrice\":7400.1,\"highPrice\":7411.11,\"lowPrice\":7400.0,\"openPrice\":7411.11,\"time\":1492747200,\"vol\":16.747},{\"closePrice\":7417.04,\"highPrice\":7425.88,\"lowPrice\":7411.1,\"openPrice\":7425.88,\"time\":1492746300,\"vol\":12.421},{\"closePrice\":7425.0,\"highPrice\":7425.0,\"lowPrice\":7425.0,\"openPrice\":7425.0,\"time\":1492745400,\"vol\":6.614},{\"closePrice\":7423.59,\"highPrice\":7465.0,\"lowPrice\":7423.59,\"openPrice\":7465.0,\"time\":1492744500,\"vol\":3.032},{\"closePrice\":7465.0,\"highPrice\":7493.98,\"lowPrice\":7451.0,\"openPrice\":7493.98,\"time\":1492743600,\"vol\":9.769},{\"closePrice\":7499.92,\"highPrice\":7499.99,\"lowPrice\":7465.0,\"openPrice\":7488.46,\"time\":1492742700,\"vol\":10.412},{\"closePrice\":7493.0,\"highPrice\":7500.0,\"lowPrice\":7433.0,\"openPrice\":7433.0,\"time\":1492741800,\"vol\":34.38},{\"closePrice\":7430.0,\"highPrice\":7430.0,\"lowPrice\":7416.65,\"openPrice\":7416.65,\"time\":1492740900,\"vol\":8.102},{\"closePrice\":7420.0,\"highPrice\":7420.0,\"lowPrice\":7350.89,\"openPrice\":7362.0,\"time\":1492740000,\"vol\":45.371},{\"closePrice\":7360.0,\"highPrice\":7362.0,\"lowPrice\":7358.0,\"openPrice\":7358.0,\"time\":1492739100,\"vol\":2.073},{\"closePrice\":7358.0,\"highPrice\":7358.0,\"lowPrice\":7350.0,\"openPrice\":7350.0,\"time\":1492738200,\"vol\":4.137},{\"closePrice\":7357.9,\"highPrice\":7357.9,\"lowPrice\":7350.0,\"openPrice\":7350.0,\"time\":1492737300,\"vol\":0.222},{\"closePrice\":7350.0,\"highPrice\":7350.0,\"lowPrice\":7330.0,\"openPrice\":7330.0,\"time\":1492736400,\"vol\":5.713},{\"closePrice\":7330.0,\"highPrice\":7331.0,\"lowPrice\":7330.0,\"openPrice\":7331.0,\"time\":1492735500,\"vol\":4.541},{\"closePrice\":7330.0,\"highPrice\":7345.0,\"lowPrice\":7330.0,\"openPrice\":7345.0,\"time\":1492734600,\"vol\":3.802},{\"closePrice\":7345.0,\"highPrice\":7361.0,\"lowPrice\":7339.0,\"openPrice\":7361.0,\"time\":1492733700,\"vol\":3.109},{\"closePrice\":7361.0,\"highPrice\":7361.0,\"lowPrice\":7357.9,\"openPrice\":7357.9,\"time\":1492732800,\"vol\":9.77},{\"closePrice\":7359.53,\"highPrice\":7359.53,\"lowPrice\":7331.0,\"openPrice\":7331.03,\"time\":1492731900,\"vol\":11.104},{\"closePrice\":7330.09,\"highPrice\":7330.09,\"lowPrice\":7329.77,\"openPrice\":7329.77,\"time\":1492731000,\"vol\":8.921},{\"closePrice\":7323.33,\"highPrice\":7350.0,\"lowPrice\":7242.3,\"openPrice\":7256.0,\"time\":1492730100,\"vol\":25.023},{\"closePrice\":7242.3,\"highPrice\":7263.19,\"lowPrice\":7242.3,\"openPrice\":7242.3,\"time\":1492729200,\"vol\":3.936},{\"closePrice\":7251.62,\"highPrice\":7267.0,\"lowPrice\":7248.33,\"openPrice\":7267.0,\"time\":1492728300,\"vol\":4.049},{\"closePrice\":7267.0,\"highPrice\":7268.35,\"lowPrice\":7267.0,\"openPrice\":7268.35,\"time\":1492727400,\"vol\":4.061},{\"closePrice\":7267.0,\"highPrice\":7298.93,\"lowPrice\":7267.0,\"openPrice\":7296.89,\"time\":1492726500,\"vol\":10.043},{\"closePrice\":7299.03,\"highPrice\":7299.03,\"lowPrice\":7276.11,\"openPrice\":7297.94,\"time\":1492725600,\"vol\":1.981},{\"closePrice\":7303.0,\"highPrice\":7303.0,\"lowPrice\":7286.09,\"openPrice\":7286.09,\"time\":1492722000,\"vol\":0.351},{\"closePrice\":7302.0,\"highPrice\":7302.92,\"lowPrice\":7302.0,\"openPrice\":7302.92,\"time\":1492720200,\"vol\":0.12},{\"closePrice\":7302.91,\"highPrice\":7302.91,\"lowPrice\":7276.0,\"openPrice\":7276.0,\"time\":1492719300,\"vol\":0.98},{\"closePrice\":7276.0,\"highPrice\":7276.0,\"lowPrice\":7276.0,\"openPrice\":7276.0,\"time\":1492718400,\"vol\":2.15},{\"closePrice\":7276.0,\"highPrice\":7298.33,\"lowPrice\":7276.0,\"openPrice\":7298.33,\"time\":1492716600,\"vol\":4.507},{\"closePrice\":7305.0,\"highPrice\":7305.0,\"lowPrice\":7305.0,\"openPrice\":7305.0,\"time\":1492712100,\"vol\":1.341},{\"closePrice\":7305.14,\"highPrice\":7323.3,\"lowPrice\":7305.14,\"openPrice\":7323.3,\"time\":1492711200,\"vol\":2.183},{\"closePrice\":7323.3,\"highPrice\":7345.67,\"lowPrice\":7323.3,\"openPrice\":7345.65,\"time\":1492710300,\"vol\":1.899},{\"closePrice\":7345.67,\"highPrice\":7345.67,\"lowPrice\":7339.0,\"openPrice\":7339.0,\"time\":1492709400,\"vol\":1.893},{\"closePrice\":7323.33,\"highPrice\":7323.33,\"lowPrice\":7323.33,\"openPrice\":7323.33,\"time\":1492708500,\"vol\":0.953},{\"closePrice\":7323.33,\"highPrice\":7323.33,\"lowPrice\":7323.31,\"openPrice\":7323.33,\"time\":1492707600,\"vol\":2.581},{\"closePrice\":7350.0,\"highPrice\":7350.09,\"lowPrice\":7278.0,\"openPrice\":7278.0,\"time\":1492706700,\"vol\":45.873},{\"closePrice\":7278.0,\"highPrice\":7320.0,\"lowPrice\":7267.0,\"openPrice\":7320.0,\"time\":1492705800,\"vol\":7.741},{\"closePrice\":7320.0,\"highPrice\":7323.33,\"lowPrice\":7285.0,\"openPrice\":7285.0,\"time\":1492704900,\"vol\":38.185},{\"closePrice\":7280.0,\"highPrice\":7280.0,\"lowPrice\":7245.0,\"openPrice\":7247.0,\"time\":1492704000,\"vol\":25.748},{\"closePrice\":7245.0,\"highPrice\":7249.0,\"lowPrice\":7212.94,\"openPrice\":7230.0,\"time\":1492703100,\"vol\":22.641},{\"closePrice\":7230.0,\"highPrice\":7230.0,\"lowPrice\":7211.64,\"openPrice\":7218.81,\"time\":1492702200,\"vol\":9.987},{\"closePrice\":7196.37,\"highPrice\":7200.0,\"lowPrice\":7183.51,\"openPrice\":7193.56,\"time\":1492701300,\"vol\":3.697},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7182.94,\"openPrice\":7191.7,\"time\":1492700400,\"vol\":6.181},{\"closePrice\":7191.94,\"highPrice\":7191.94,\"lowPrice\":7188.0,\"openPrice\":7188.0,\"time\":1492699500,\"vol\":1.503},{\"closePrice\":7188.0,\"highPrice\":7189.0,\"lowPrice\":7188.0,\"openPrice\":7189.0,\"time\":1492698600,\"vol\":1.217},{\"closePrice\":7169.13,\"highPrice\":7184.04,\"lowPrice\":7169.13,\"openPrice\":7182.0,\"time\":1492697700,\"vol\":0.447},{\"closePrice\":7189.0,\"highPrice\":7189.0,\"lowPrice\":7163.81,\"openPrice\":7163.81,\"time\":1492696800,\"vol\":3.964},{\"closePrice\":7151.68,\"highPrice\":7151.68,\"lowPrice\":7151.68,\"openPrice\":7151.68,\"time\":1492695900,\"vol\":0.04},{\"closePrice\":7151.0,\"highPrice\":7155.0,\"lowPrice\":7151.0,\"openPrice\":7155.0,\"time\":1492695000,\"vol\":5.59},{\"closePrice\":7151.06,\"highPrice\":7183.0,\"lowPrice\":7151.06,\"openPrice\":7183.0,\"time\":1492694100,\"vol\":0.782},{\"closePrice\":7189.0,\"highPrice\":7189.0,\"lowPrice\":7188.97,\"openPrice\":7188.97,\"time\":1492693200,\"vol\":6.411},{\"closePrice\":7189.91,\"highPrice\":7189.91,\"lowPrice\":7151.0,\"openPrice\":7151.26,\"time\":1492691400,\"vol\":1.019},{\"closePrice\":7188.93,\"highPrice\":7191.94,\"lowPrice\":7151.01,\"openPrice\":7191.94,\"time\":1492690500,\"vol\":6.224},{\"closePrice\":7151.02,\"highPrice\":7191.97,\"lowPrice\":7151.02,\"openPrice\":7191.97,\"time\":1492689600,\"vol\":0.164},{\"closePrice\":7191.97,\"highPrice\":7191.97,\"lowPrice\":7191.97,\"openPrice\":7191.97,\"time\":1492688700,\"vol\":0.507},{\"closePrice\":7151.01,\"highPrice\":7170.0,\"lowPrice\":7151.01,\"openPrice\":7170.0,\"time\":1492687800,\"vol\":0.964},{\"closePrice\":7170.0,\"highPrice\":7192.0,\"lowPrice\":7170.0,\"openPrice\":7191.91,\"time\":1492686900,\"vol\":0.829},{\"closePrice\":7192.0,\"highPrice\":7196.94,\"lowPrice\":7151.0,\"openPrice\":7161.0,\"time\":1492686000,\"vol\":4.174},{\"closePrice\":7161.0,\"highPrice\":7173.34,\"lowPrice\":7161.0,\"openPrice\":7173.34,\"time\":1492685100,\"vol\":2.496},{\"closePrice\":7173.34,\"highPrice\":7173.34,\"lowPrice\":7173.34,\"openPrice\":7173.34,\"time\":1492684200,\"vol\":0.014},{\"closePrice\":7163.0,\"highPrice\":7163.0,\"lowPrice\":7163.0,\"openPrice\":7163.0,\"time\":1492682400,\"vol\":1.052},{\"closePrice\":7151.0,\"highPrice\":7151.09,\"lowPrice\":7151.0,\"openPrice\":7151.09,\"time\":1492680600,\"vol\":1.402},{\"closePrice\":7173.34,\"highPrice\":7173.34,\"lowPrice\":7171.0,\"openPrice\":7173.33,\"time\":1492677900,\"vol\":3.541},{\"closePrice\":7173.33,\"highPrice\":7192.06,\"lowPrice\":7173.33,\"openPrice\":7192.06,\"time\":1492677000,\"vol\":20.452},{\"closePrice\":7192.0,\"highPrice\":7200.0,\"lowPrice\":7192.0,\"openPrice\":7198.22,\"time\":1492676100,\"vol\":4.439},{\"closePrice\":7198.33,\"highPrice\":7198.33,\"lowPrice\":7198.29,\"openPrice\":7198.29,\"time\":1492674300,\"vol\":0.066},{\"closePrice\":7198.33,\"highPrice\":7198.33,\"lowPrice\":7198.33,\"openPrice\":7198.33,\"time\":1492673400,\"vol\":0.26},{\"closePrice\":7198.34,\"highPrice\":7209.92,\"lowPrice\":7198.34,\"openPrice\":7200.01,\"time\":1492672500,\"vol\":4.002},{\"closePrice\":7200.01,\"highPrice\":7200.01,\"lowPrice\":7200.01,\"openPrice\":7200.01,\"time\":1492671600,\"vol\":1.043},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492670700,\"vol\":0.1},{\"closePrice\":7200.01,\"highPrice\":7200.01,\"lowPrice\":7200.01,\"openPrice\":7200.01,\"time\":1492668900,\"vol\":3.402},{\"closePrice\":7200.0,\"highPrice\":7200.03,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492668000,\"vol\":1.061},{\"closePrice\":7200.0,\"highPrice\":7201.0,\"lowPrice\":7200.0,\"openPrice\":7201.0,\"time\":1492667100,\"vol\":1.52},{\"closePrice\":7200.0,\"highPrice\":7201.0,\"lowPrice\":7200.0,\"openPrice\":7201.0,\"time\":1492666200,\"vol\":4.095},{\"closePrice\":7210.0,\"highPrice\":7228.0,\"lowPrice\":7210.0,\"openPrice\":7228.0,\"time\":1492665300,\"vol\":3.557},{\"closePrice\":7229.99,\"highPrice\":7229.99,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492663500,\"vol\":2.269},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492662600,\"vol\":0.1},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492661700,\"vol\":2.576},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492660800,\"vol\":0.299},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492659900,\"vol\":0.028},{\"closePrice\":7210.0,\"highPrice\":7212.99,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492659000,\"vol\":2.384},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492658100,\"vol\":1.356},{\"closePrice\":7215.0,\"highPrice\":7215.0,\"lowPrice\":7201.0,\"openPrice\":7201.0,\"time\":1492657200,\"vol\":21.811},{\"closePrice\":7201.0,\"highPrice\":7201.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492655400,\"vol\":1.689},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492654500,\"vol\":0.488},{\"closePrice\":7200.0,\"highPrice\":7202.0,\"lowPrice\":7200.0,\"openPrice\":7200.08,\"time\":1492653600,\"vol\":2.663},{\"closePrice\":7200.08,\"highPrice\":7210.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492652700,\"vol\":7.166},{\"closePrice\":7200.0,\"highPrice\":7200.17,\"lowPrice\":7164.09,\"openPrice\":7164.09,\"time\":1492651800,\"vol\":24.716},{\"closePrice\":7197.99,\"highPrice\":7197.99,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492650900,\"vol\":14.225},{\"closePrice\":7180.7,\"highPrice\":7180.7,\"lowPrice\":7158.93,\"openPrice\":7158.93,\"time\":1492650000,\"vol\":0.022},{\"closePrice\":7184.72,\"highPrice\":7184.81,\"lowPrice\":7152.0,\"openPrice\":7170.94,\"time\":1492649100,\"vol\":6.232},{\"closePrice\":7156.0,\"highPrice\":7180.0,\"lowPrice\":7156.0,\"openPrice\":7180.0,\"time\":1492648200,\"vol\":3.983},{\"closePrice\":7180.0,\"highPrice\":7185.0,\"lowPrice\":7179.0,\"openPrice\":7180.0,\"time\":1492647300,\"vol\":12.865},{\"closePrice\":7179.02,\"highPrice\":7180.0,\"lowPrice\":7150.08,\"openPrice\":7150.08,\"time\":1492646400,\"vol\":14.63},{\"closePrice\":7178.9,\"highPrice\":7178.9,\"lowPrice\":7150.0,\"openPrice\":7150.02,\"time\":1492645500,\"vol\":5.637},{\"closePrice\":7179.0,\"highPrice\":7180.0,\"lowPrice\":7154.97,\"openPrice\":7154.97,\"time\":1492644600,\"vol\":10.797},{\"closePrice\":7154.97,\"highPrice\":7154.97,\"lowPrice\":7147.9,\"openPrice\":7147.9,\"time\":1492643700,\"vol\":6.907},{\"closePrice\":7123.44,\"highPrice\":7123.44,\"lowPrice\":7123.27,\"openPrice\":7123.27,\"time\":1492642800,\"vol\":1.043},{\"closePrice\":7100.0,\"highPrice\":7100.0,\"lowPrice\":7100.0,\"openPrice\":7100.0,\"time\":1492641900,\"vol\":0.337},{\"closePrice\":7098.0,\"highPrice\":7098.0,\"lowPrice\":7098.0,\"openPrice\":7098.0,\"time\":1492641000,\"vol\":0.088},{\"closePrice\":7110.0,\"highPrice\":7115.0,\"lowPrice\":7110.0,\"openPrice\":7110.0,\"time\":1492637400,\"vol\":6.745},{\"closePrice\":7110.0,\"highPrice\":7120.06,\"lowPrice\":7098.33,\"openPrice\":7101.1,\"time\":1492636500,\"vol\":7.943},{\"closePrice\":7101.0,\"highPrice\":7101.01,\"lowPrice\":7101.0,\"openPrice\":7101.01,\"time\":1492635600,\"vol\":1.185},{\"closePrice\":7101.0,\"highPrice\":7102.01,\"lowPrice\":7101.0,\"openPrice\":7102.01,\"time\":1492632900,\"vol\":2.0},{\"closePrice\":7102.01,\"highPrice\":7108.0,\"lowPrice\":7102.01,\"openPrice\":7108.0,\"time\":1492632000,\"vol\":1.37},{\"closePrice\":7108.0,\"highPrice\":7108.0,\"lowPrice\":7108.0,\"openPrice\":7108.0,\"time\":1492630200,\"vol\":0.001},{\"closePrice\":7120.06,\"highPrice\":7135.99,\"lowPrice\":7120.06,\"openPrice\":7135.99,\"time\":1492629300,\"vol\":2.894},{\"closePrice\":7150.0,\"highPrice\":7150.0,\"lowPrice\":7150.0,\"openPrice\":7150.0,\"time\":1492625700,\"vol\":0.276},{\"closePrice\":7150.0,\"highPrice\":7150.0,\"lowPrice\":7150.0,\"openPrice\":7150.0,\"time\":1492623000,\"vol\":2.621},{\"closePrice\":7135.99,\"highPrice\":7150.0,\"lowPrice\":7135.99,\"openPrice\":7135.99,\"time\":1492622100,\"vol\":7.124},{\"closePrice\":7135.99,\"highPrice\":7135.99,\"lowPrice\":7123.0,\"openPrice\":7123.0,\"time\":1492620300,\"vol\":1.689},{\"closePrice\":7103.0,\"highPrice\":7123.32,\"lowPrice\":7103.0,\"openPrice\":7123.32,\"time\":1492617600,\"vol\":0.755},{\"closePrice\":7102.01,\"highPrice\":7102.01,\"lowPrice\":7102.01,\"openPrice\":7102.01,\"time\":1492616700,\"vol\":0.309},{\"closePrice\":7120.0,\"highPrice\":7120.0,\"lowPrice\":7120.0,\"openPrice\":7120.0,\"time\":1492615800,\"vol\":0.005},{\"closePrice\":7123.32,\"highPrice\":7123.32,\"lowPrice\":7123.32,\"openPrice\":7123.32,\"time\":1492614900,\"vol\":0.15},{\"closePrice\":7100.0,\"highPrice\":7100.0,\"lowPrice\":7100.0,\"openPrice\":7100.0,\"time\":1492614000,\"vol\":1.512},{\"closePrice\":7094.01,\"highPrice\":7101.0,\"lowPrice\":7094.01,\"openPrice\":7101.0,\"time\":1492613100,\"vol\":1.426},{\"closePrice\":7090.09,\"highPrice\":7101.0,\"lowPrice\":7090.09,\"openPrice\":7101.0,\"time\":1492610400,\"vol\":3.642},{\"closePrice\":7101.0,\"highPrice\":7101.0,\"lowPrice\":7101.0,\"openPrice\":7101.0,\"time\":1492608600,\"vol\":8.024},{\"closePrice\":7090.0,\"highPrice\":7101.0,\"lowPrice\":7090.0,\"openPrice\":7101.0,\"time\":1492607700,\"vol\":1.262},{\"closePrice\":7101.0,\"highPrice\":7101.0,\"lowPrice\":7101.0,\"openPrice\":7101.0,\"time\":1492606800,\"vol\":4.156},{\"closePrice\":7101.0,\"highPrice\":7101.0,\"lowPrice\":7091.0,\"openPrice\":7100.0,\"time\":1492605900,\"vol\":4.691},{\"closePrice\":7101.0,\"highPrice\":7101.0,\"lowPrice\":7100.0,\"openPrice\":7100.0,\"time\":1492605000,\"vol\":4.586},{\"closePrice\":7100.0,\"highPrice\":7100.0,\"lowPrice\":7100.0,\"openPrice\":7100.0,\"time\":1492604100,\"vol\":3.448},{\"closePrice\":7090.0,\"highPrice\":7100.0,\"lowPrice\":7089.11,\"openPrice\":7100.0,\"time\":1492602300,\"vol\":0.989},{\"closePrice\":7089.11,\"highPrice\":7089.53,\"lowPrice\":7088.0,\"openPrice\":7089.53,\"time\":1492601400,\"vol\":1.059},{\"closePrice\":7089.53,\"highPrice\":7101.0,\"lowPrice\":7089.5,\"openPrice\":7100.01,\"time\":1492600500,\"vol\":9.915},{\"closePrice\":7101.0,\"highPrice\":7120.0,\"lowPrice\":7100.0,\"openPrice\":7120.0,\"time\":1492599600,\"vol\":12.489},{\"closePrice\":7120.0,\"highPrice\":7121.06,\"lowPrice\":7120.0,\"openPrice\":7121.06,\"time\":1492598700,\"vol\":2.494},{\"closePrice\":7135.0,\"highPrice\":7135.0,\"lowPrice\":7134.99,\"openPrice\":7134.99,\"time\":1492595100,\"vol\":1.995},{\"closePrice\":7120.0,\"highPrice\":7134.99,\"lowPrice\":7120.0,\"openPrice\":7134.99,\"time\":1492594200,\"vol\":1.004},{\"closePrice\":7134.99,\"highPrice\":7134.99,\"lowPrice\":7120.01,\"openPrice\":7121.0,\"time\":1492593300,\"vol\":0.44},{\"closePrice\":7135.98,\"highPrice\":7135.98,\"lowPrice\":7121.1,\"openPrice\":7121.1,\"time\":1492592400,\"vol\":0.702},{\"closePrice\":7121.1,\"highPrice\":7121.1,\"lowPrice\":7121.1,\"openPrice\":7121.1,\"time\":1492591500,\"vol\":2.0},{\"closePrice\":7135.99,\"highPrice\":7135.99,\"lowPrice\":7135.99,\"openPrice\":7135.99,\"time\":1492590600,\"vol\":1.875},{\"closePrice\":7135.99,\"highPrice\":7135.99,\"lowPrice\":7121.0,\"openPrice\":7121.0,\"time\":1492589700,\"vol\":0.026},{\"closePrice\":7120.0,\"highPrice\":7123.0,\"lowPrice\":7120.0,\"openPrice\":7123.0,\"time\":1492587900,\"vol\":6.063},{\"closePrice\":7136.0,\"highPrice\":7136.0,\"lowPrice\":7134.94,\"openPrice\":7134.94,\"time\":1492587000,\"vol\":2.0},{\"closePrice\":7123.0,\"highPrice\":7123.1,\"lowPrice\":7123.0,\"openPrice\":7123.1,\"time\":1492586100,\"vol\":2.575},{\"closePrice\":7134.95,\"highPrice\":7134.95,\"lowPrice\":7134.95,\"openPrice\":7134.95,\"time\":1492584300,\"vol\":0.023},{\"closePrice\":7135.0,\"highPrice\":7135.0,\"lowPrice\":7135.0,\"openPrice\":7135.0,\"time\":1492583400,\"vol\":2.136},{\"closePrice\":7136.0,\"highPrice\":7136.0,\"lowPrice\":7123.0,\"openPrice\":7135.0,\"time\":1492582500,\"vol\":1.381},{\"closePrice\":7123.0,\"highPrice\":7131.0,\"lowPrice\":7123.0,\"openPrice\":7131.0,\"time\":1492581600,\"vol\":4.86},{\"closePrice\":7130.0,\"highPrice\":7135.0,\"lowPrice\":7130.0,\"openPrice\":7135.0,\"time\":1492579800,\"vol\":1.0},{\"closePrice\":7130.0,\"highPrice\":7135.0,\"lowPrice\":7130.0,\"openPrice\":7135.0,\"time\":1492577100,\"vol\":1.405},{\"closePrice\":7131.0,\"highPrice\":7131.0,\"lowPrice\":7131.0,\"openPrice\":7131.0,\"time\":1492576200,\"vol\":0.18},{\"closePrice\":7147.99,\"highPrice\":7147.99,\"lowPrice\":7147.99,\"openPrice\":7147.99,\"time\":1492572600,\"vol\":0.013},{\"closePrice\":7131.0,\"highPrice\":7133.01,\"lowPrice\":7131.0,\"openPrice\":7133.01,\"time\":1492571700,\"vol\":3.012},{\"closePrice\":7133.0,\"highPrice\":7133.0,\"lowPrice\":7133.0,\"openPrice\":7133.0,\"time\":1492569000,\"vol\":0.02},{\"closePrice\":7133.0,\"highPrice\":7133.0,\"lowPrice\":7133.0,\"openPrice\":7133.0,\"time\":1492568100,\"vol\":1.274},{\"closePrice\":7133.0,\"highPrice\":7133.0,\"lowPrice\":7133.0,\"openPrice\":7133.0,\"time\":1492567200,\"vol\":0.168},{\"closePrice\":7148.0,\"highPrice\":7148.0,\"lowPrice\":7133.0,\"openPrice\":7133.0,\"time\":1492566300,\"vol\":0.689},{\"closePrice\":7148.33,\"highPrice\":7154.97,\"lowPrice\":7142.98,\"openPrice\":7142.98,\"time\":1492564500,\"vol\":5.98},{\"closePrice\":7143.0,\"highPrice\":7145.0,\"lowPrice\":7129.01,\"openPrice\":7145.0,\"time\":1492562700,\"vol\":1.928},{\"closePrice\":7129.01,\"highPrice\":7154.97,\"lowPrice\":7129.01,\"openPrice\":7154.97,\"time\":1492561800,\"vol\":1.32},{\"closePrice\":7129.01,\"highPrice\":7130.0,\"lowPrice\":7129.01,\"openPrice\":7130.0,\"time\":1492560900,\"vol\":0.831},{\"closePrice\":7130.0,\"highPrice\":7135.0,\"lowPrice\":7130.0,\"openPrice\":7135.0,\"time\":1492560000,\"vol\":1.185},{\"closePrice\":7135.0,\"highPrice\":7135.0,\"lowPrice\":7135.0,\"openPrice\":7135.0,\"time\":1492559100,\"vol\":1.738},{\"closePrice\":7130.0,\"highPrice\":7131.1,\"lowPrice\":7130.0,\"openPrice\":7131.1,\"time\":1492558200,\"vol\":3.0},{\"closePrice\":7130.0,\"highPrice\":7140.5,\"lowPrice\":7130.0,\"openPrice\":7140.5,\"time\":1492557300,\"vol\":1.185},{\"closePrice\":7140.5,\"highPrice\":7157.0,\"lowPrice\":7140.5,\"openPrice\":7157.0,\"time\":1492556400,\"vol\":1.133},{\"closePrice\":7157.0,\"highPrice\":7157.0,\"lowPrice\":7149.0,\"openPrice\":7149.0,\"time\":1492555500,\"vol\":2.885},{\"closePrice\":7140.5,\"highPrice\":7140.5,\"lowPrice\":7140.5,\"openPrice\":7140.5,\"time\":1492552800,\"vol\":0.753},{\"closePrice\":7129.02,\"highPrice\":7130.0,\"lowPrice\":7129.02,\"openPrice\":7130.0,\"time\":1492551000,\"vol\":0.92},{\"closePrice\":7129.01,\"highPrice\":7129.01,\"lowPrice\":7129.01,\"openPrice\":7129.01,\"time\":1492547400,\"vol\":0.278},{\"closePrice\":7137.0,\"highPrice\":7138.0,\"lowPrice\":7137.0,\"openPrice\":7138.0,\"time\":1492539300,\"vol\":0.972},{\"closePrice\":7137.0,\"highPrice\":7137.0,\"lowPrice\":7137.0,\"openPrice\":7137.0,\"time\":1492535700,\"vol\":0.116},{\"closePrice\":7140.5,\"highPrice\":7140.5,\"lowPrice\":7140.5,\"openPrice\":7140.5,\"time\":1492534800,\"vol\":0.004},{\"closePrice\":7129.0,\"highPrice\":7129.0,\"lowPrice\":7129.0,\"openPrice\":7129.0,\"time\":1492530300,\"vol\":0.757},{\"closePrice\":7149.0,\"highPrice\":7149.0,\"lowPrice\":7122.0,\"openPrice\":7122.02,\"time\":1492526700,\"vol\":11.481},{\"closePrice\":7121.0,\"highPrice\":7121.0,\"lowPrice\":7121.0,\"openPrice\":7121.0,\"time\":1492524900,\"vol\":0.735},{\"closePrice\":7158.99,\"highPrice\":7158.99,\"lowPrice\":7158.99,\"openPrice\":7158.99,\"time\":1492524000,\"vol\":0.2},{\"closePrice\":7120.0,\"highPrice\":7160.0,\"lowPrice\":7120.0,\"openPrice\":7160.0,\"time\":1492523100,\"vol\":7.83},{\"closePrice\":7140.1,\"highPrice\":7160.0,\"lowPrice\":7140.0,\"openPrice\":7140.0,\"time\":1492522200,\"vol\":1.772},{\"closePrice\":7140.0,\"highPrice\":7145.0,\"lowPrice\":7140.0,\"openPrice\":7141.1,\"time\":1492521300,\"vol\":6.347},{\"closePrice\":7141.1,\"highPrice\":7150.05,\"lowPrice\":7141.1,\"openPrice\":7150.05,\"time\":1492520400,\"vol\":15.212},{\"closePrice\":7150.04,\"highPrice\":7150.05,\"lowPrice\":7150.04,\"openPrice\":7150.05,\"time\":1492519500,\"vol\":2.127},{\"closePrice\":7150.02,\"highPrice\":7165.99,\"lowPrice\":7150.02,\"openPrice\":7165.99,\"time\":1492518600,\"vol\":2.334},{\"closePrice\":7165.99,\"highPrice\":7165.99,\"lowPrice\":7165.99,\"openPrice\":7165.99,\"time\":1492517700,\"vol\":0.301},{\"closePrice\":7165.99,\"highPrice\":7165.99,\"lowPrice\":7165.99,\"openPrice\":7165.99,\"time\":1492514100,\"vol\":0.123},{\"closePrice\":7168.0,\"highPrice\":7168.0,\"lowPrice\":7168.0,\"openPrice\":7168.0,\"time\":1492513200,\"vol\":0.05},{\"closePrice\":7142.0,\"highPrice\":7142.0,\"lowPrice\":7142.0,\"openPrice\":7142.0,\"time\":1492512300,\"vol\":0.721},{\"closePrice\":7141.0,\"highPrice\":7150.0,\"lowPrice\":7141.0,\"openPrice\":7150.0,\"time\":1492511400,\"vol\":0.215},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7140.0,\"openPrice\":7140.0,\"time\":1492509600,\"vol\":2.278},{\"closePrice\":7140.0,\"highPrice\":7146.01,\"lowPrice\":7140.0,\"openPrice\":7146.01,\"time\":1492508700,\"vol\":11.556},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7150.0,\"openPrice\":7150.0,\"time\":1492506900,\"vol\":1.938},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492506000,\"vol\":0.335},{\"closePrice\":7150.0,\"highPrice\":7151.01,\"lowPrice\":7150.0,\"openPrice\":7151.01,\"time\":1492505100,\"vol\":1.43},{\"closePrice\":7169.99,\"highPrice\":7169.99,\"lowPrice\":7169.98,\"openPrice\":7169.98,\"time\":1492504200,\"vol\":0.464},{\"closePrice\":7150.0,\"highPrice\":7150.0,\"lowPrice\":7150.0,\"openPrice\":7150.0,\"time\":1492502400,\"vol\":0.127},{\"closePrice\":7152.8,\"highPrice\":7152.8,\"lowPrice\":7150.0,\"openPrice\":7150.0,\"time\":1492501500,\"vol\":0.312},{\"closePrice\":7150.0,\"highPrice\":7150.0,\"lowPrice\":7143.01,\"openPrice\":7148.2,\"time\":1492500600,\"vol\":4.718},{\"closePrice\":7148.0,\"highPrice\":7148.0,\"lowPrice\":7148.0,\"openPrice\":7148.0,\"time\":1492499700,\"vol\":1.28},{\"closePrice\":7152.8,\"highPrice\":7152.8,\"lowPrice\":7152.8,\"openPrice\":7152.8,\"time\":1492497900,\"vol\":0.348},{\"closePrice\":7148.0,\"highPrice\":7152.8,\"lowPrice\":7148.0,\"openPrice\":7152.8,\"time\":1492497000,\"vol\":0.011},{\"closePrice\":7143.0,\"highPrice\":7170.0,\"lowPrice\":7143.0,\"openPrice\":7170.0,\"time\":1492496100,\"vol\":0.002},{\"closePrice\":7170.0,\"highPrice\":7170.0,\"lowPrice\":7143.0,\"openPrice\":7143.0,\"time\":1492495200,\"vol\":0.06},{\"closePrice\":7140.01,\"highPrice\":7152.8,\"lowPrice\":7140.0,\"openPrice\":7152.8,\"time\":1492494300,\"vol\":5.625},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492493400,\"vol\":0.969},{\"closePrice\":7171.0,\"highPrice\":7200.0,\"lowPrice\":7171.0,\"openPrice\":7191.99,\"time\":1492491600,\"vol\":5.602},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7187.68,\"openPrice\":7187.68,\"time\":1492488900,\"vol\":12.316},{\"closePrice\":7188.0,\"highPrice\":7188.0,\"lowPrice\":7152.0,\"openPrice\":7152.0,\"time\":1492488000,\"vol\":0.033},{\"closePrice\":7152.51,\"highPrice\":7190.0,\"lowPrice\":7152.51,\"openPrice\":7190.0,\"time\":1492487100,\"vol\":0.738},{\"closePrice\":7171.0,\"highPrice\":7192.0,\"lowPrice\":7143.0,\"openPrice\":7190.0,\"time\":1492486200,\"vol\":12.716},{\"closePrice\":7151.07,\"highPrice\":7190.0,\"lowPrice\":7151.07,\"openPrice\":7190.0,\"time\":1492484400,\"vol\":0.374},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7150.0,\"openPrice\":7171.0,\"time\":1492483500,\"vol\":7.922},{\"closePrice\":7150.0,\"highPrice\":7210.0,\"lowPrice\":7150.0,\"openPrice\":7210.0,\"time\":1492482600,\"vol\":25.511},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7191.95,\"openPrice\":7191.95,\"time\":1492481700,\"vol\":7.164},{\"closePrice\":7192.0,\"highPrice\":7192.0,\"lowPrice\":7192.0,\"openPrice\":7192.0,\"time\":1492480800,\"vol\":0.013},{\"closePrice\":7160.0,\"highPrice\":7160.01,\"lowPrice\":7160.0,\"openPrice\":7160.01,\"time\":1492479000,\"vol\":0.5},{\"closePrice\":7160.0,\"highPrice\":7162.0,\"lowPrice\":7160.0,\"openPrice\":7162.0,\"time\":1492478100,\"vol\":3.082},{\"closePrice\":7152.0,\"highPrice\":7152.0,\"lowPrice\":7152.0,\"openPrice\":7152.0,\"time\":1492476300,\"vol\":0.4},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7140.04,\"openPrice\":7140.04,\"time\":1492475400,\"vol\":0.816},{\"closePrice\":7140.01,\"highPrice\":7161.0,\"lowPrice\":7140.01,\"openPrice\":7161.0,\"time\":1492474500,\"vol\":5.0},{\"closePrice\":7160.0,\"highPrice\":7160.0,\"lowPrice\":7160.0,\"openPrice\":7160.0,\"time\":1492473600,\"vol\":1.755},{\"closePrice\":7151.01,\"highPrice\":7152.0,\"lowPrice\":7151.01,\"openPrice\":7152.0,\"time\":1492472700,\"vol\":0.296},{\"closePrice\":7150.11,\"highPrice\":7150.11,\"lowPrice\":7150.11,\"openPrice\":7150.11,\"time\":1492471800,\"vol\":2.301},{\"closePrice\":7150.11,\"highPrice\":7200.0,\"lowPrice\":7150.11,\"openPrice\":7200.0,\"time\":1492470900,\"vol\":5.392},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492470000,\"vol\":0.253},{\"closePrice\":7150.0,\"highPrice\":7156.09,\"lowPrice\":7150.0,\"openPrice\":7156.09,\"time\":1492469100,\"vol\":31.534},{\"closePrice\":7170.0,\"highPrice\":7170.0,\"lowPrice\":7170.0,\"openPrice\":7170.0,\"time\":1492468200,\"vol\":18.695},{\"closePrice\":7170.0,\"highPrice\":7170.0,\"lowPrice\":7170.0,\"openPrice\":7170.0,\"time\":1492467300,\"vol\":0.15},{\"closePrice\":7170.0,\"highPrice\":7170.0,\"lowPrice\":7170.0,\"openPrice\":7170.0,\"time\":1492466400,\"vol\":8.805},{\"closePrice\":7170.0,\"highPrice\":7170.01,\"lowPrice\":7170.0,\"openPrice\":7170.01,\"time\":1492461900,\"vol\":1.265},{\"closePrice\":7170.01,\"highPrice\":7170.01,\"lowPrice\":7170.01,\"openPrice\":7170.01,\"time\":1492461000,\"vol\":0.021},{\"closePrice\":7170.01,\"highPrice\":7171.0,\"lowPrice\":7170.01,\"openPrice\":7171.0,\"time\":1492453800,\"vol\":0.136},{\"closePrice\":7171.03,\"highPrice\":7192.0,\"lowPrice\":7171.03,\"openPrice\":7192.0,\"time\":1492452000,\"vol\":1.537},{\"closePrice\":7213.0,\"highPrice\":7213.0,\"lowPrice\":7213.0,\"openPrice\":7213.0,\"time\":1492444800,\"vol\":0.295},{\"closePrice\":7213.0,\"highPrice\":7220.0,\"lowPrice\":7213.0,\"openPrice\":7220.0,\"time\":1492443900,\"vol\":0.354},{\"closePrice\":7230.0,\"highPrice\":7250.0,\"lowPrice\":7230.0,\"openPrice\":7250.0,\"time\":1492443000,\"vol\":1.492},{\"closePrice\":7260.0,\"highPrice\":7260.0,\"lowPrice\":7186.0,\"openPrice\":7186.0,\"time\":1492442100,\"vol\":17.962},{\"closePrice\":7186.0,\"highPrice\":7186.0,\"lowPrice\":7185.0,\"openPrice\":7185.0,\"time\":1492441200,\"vol\":1.223},{\"closePrice\":7186.0,\"highPrice\":7186.0,\"lowPrice\":7185.9,\"openPrice\":7185.9,\"time\":1492439400,\"vol\":0.122},{\"closePrice\":7151.0,\"highPrice\":7151.0,\"lowPrice\":7151.0,\"openPrice\":7151.0,\"time\":1492438500,\"vol\":2.12},{\"closePrice\":7151.0,\"highPrice\":7152.0,\"lowPrice\":7151.0,\"openPrice\":7152.0,\"time\":1492434900,\"vol\":0.386},{\"closePrice\":7152.0,\"highPrice\":7152.0,\"lowPrice\":7152.0,\"openPrice\":7152.0,\"time\":1492434000,\"vol\":1.0},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492432200,\"vol\":0.4},{\"closePrice\":7151.0,\"highPrice\":7153.0,\"lowPrice\":7151.0,\"openPrice\":7153.0,\"time\":1492431300,\"vol\":4.08},{\"closePrice\":7151.0,\"highPrice\":7151.0,\"lowPrice\":7151.0,\"openPrice\":7151.0,\"time\":1492429500,\"vol\":0.1},{\"closePrice\":7151.0,\"highPrice\":7151.0,\"lowPrice\":7151.0,\"openPrice\":7151.0,\"time\":1492427700,\"vol\":0.865},{\"closePrice\":7186.0,\"highPrice\":7186.0,\"lowPrice\":7186.0,\"openPrice\":7186.0,\"time\":1492425000,\"vol\":0.011},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492424100,\"vol\":0.054},{\"closePrice\":7150.0,\"highPrice\":7186.0,\"lowPrice\":7150.0,\"openPrice\":7186.0,\"time\":1492423200,\"vol\":6.144},{\"closePrice\":7157.0,\"highPrice\":7186.0,\"lowPrice\":7157.0,\"openPrice\":7157.01,\"time\":1492422300,\"vol\":9.768},{\"closePrice\":7157.0,\"highPrice\":7165.0,\"lowPrice\":7157.0,\"openPrice\":7165.0,\"time\":1492420500,\"vol\":0.788},{\"closePrice\":7157.0,\"highPrice\":7186.0,\"lowPrice\":7157.0,\"openPrice\":7159.0,\"time\":1492418700,\"vol\":2.55},{\"closePrice\":7188.0,\"highPrice\":7188.0,\"lowPrice\":7188.0,\"openPrice\":7188.0,\"time\":1492414200,\"vol\":0.234},{\"closePrice\":7157.0,\"highPrice\":7157.01,\"lowPrice\":7157.0,\"openPrice\":7157.01,\"time\":1492410600,\"vol\":3.121},{\"closePrice\":7157.0,\"highPrice\":7157.01,\"lowPrice\":7157.0,\"openPrice\":7157.01,\"time\":1492408800,\"vol\":1.614},{\"closePrice\":7158.0,\"highPrice\":7158.0,\"lowPrice\":7158.0,\"openPrice\":7158.0,\"time\":1492407900,\"vol\":0.1},{\"closePrice\":7157.01,\"highPrice\":7158.0,\"lowPrice\":7157.01,\"openPrice\":7158.0,\"time\":1492407000,\"vol\":1.455},{\"closePrice\":7158.0,\"highPrice\":7187.99,\"lowPrice\":7158.0,\"openPrice\":7187.99,\"time\":1492406100,\"vol\":1.3},{\"closePrice\":7157.01,\"highPrice\":7157.01,\"lowPrice\":7157.01,\"openPrice\":7157.01,\"time\":1492405200,\"vol\":0.388},{\"closePrice\":7191.99,\"highPrice\":7191.99,\"lowPrice\":7191.99,\"openPrice\":7191.99,\"time\":1492402500,\"vol\":1.0},{\"closePrice\":7192.0,\"highPrice\":7196.99,\"lowPrice\":7160.0,\"openPrice\":7160.0,\"time\":1492400700,\"vol\":0.14},{\"closePrice\":7156.0,\"highPrice\":7156.0,\"lowPrice\":7156.0,\"openPrice\":7156.0,\"time\":1492399800,\"vol\":0.775},{\"closePrice\":7160.0,\"highPrice\":7160.0,\"lowPrice\":7160.0,\"openPrice\":7160.0,\"time\":1492398900,\"vol\":0.11},{\"closePrice\":7160.0,\"highPrice\":7179.0,\"lowPrice\":7160.0,\"openPrice\":7179.0,\"time\":1492397100,\"vol\":2.879},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492396200,\"vol\":0.1},{\"closePrice\":7179.0,\"highPrice\":7179.0,\"lowPrice\":7179.0,\"openPrice\":7179.0,\"time\":1492393500,\"vol\":3.0},{\"closePrice\":7178.96,\"highPrice\":7178.96,\"lowPrice\":7178.96,\"openPrice\":7178.96,\"time\":1492392600,\"vol\":0.1},{\"closePrice\":7173.5,\"highPrice\":7189.0,\"lowPrice\":7173.5,\"openPrice\":7189.0,\"time\":1492391700,\"vol\":6.287},{\"closePrice\":7199.0,\"highPrice\":7199.0,\"lowPrice\":7199.0,\"openPrice\":7199.0,\"time\":1492388100,\"vol\":0.02},{\"closePrice\":7199.99,\"highPrice\":7199.99,\"lowPrice\":7199.99,\"openPrice\":7199.99,\"time\":1492380000,\"vol\":1.056},{\"closePrice\":7173.5,\"highPrice\":7175.51,\"lowPrice\":7173.5,\"openPrice\":7175.51,\"time\":1492378200,\"vol\":1.963},{\"closePrice\":7175.2,\"highPrice\":7175.2,\"lowPrice\":7175.2,\"openPrice\":7175.2,\"time\":1492363800,\"vol\":0.001},{\"closePrice\":7175.2,\"highPrice\":7175.2,\"lowPrice\":7175.2,\"openPrice\":7175.2,\"time\":1492362000,\"vol\":0.014},{\"closePrice\":7175.0,\"highPrice\":7175.0,\"lowPrice\":7175.0,\"openPrice\":7175.0,\"time\":1492359300,\"vol\":2.8},{\"closePrice\":7175.0,\"highPrice\":7175.0,\"lowPrice\":7175.0,\"openPrice\":7175.0,\"time\":1492358400,\"vol\":0.391},{\"closePrice\":7175.0,\"highPrice\":7175.0,\"lowPrice\":7175.0,\"openPrice\":7175.0,\"time\":1492353900,\"vol\":0.702},{\"closePrice\":7202.0,\"highPrice\":7202.0,\"lowPrice\":7199.99,\"openPrice\":7199.99,\"time\":1492353000,\"vol\":0.763},{\"closePrice\":7175.0,\"highPrice\":7175.0,\"lowPrice\":7173.5,\"openPrice\":7174.0,\"time\":1492352100,\"vol\":1.17},{\"closePrice\":7173.5,\"highPrice\":7187.5,\"lowPrice\":7173.5,\"openPrice\":7187.5,\"time\":1492350300,\"vol\":0.18},{\"closePrice\":7202.0,\"highPrice\":7202.0,\"lowPrice\":7187.5,\"openPrice\":7187.5,\"time\":1492348500,\"vol\":0.131},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492347600,\"vol\":0.077},{\"closePrice\":7173.5,\"highPrice\":7174.61,\"lowPrice\":7173.5,\"openPrice\":7174.61,\"time\":1492346700,\"vol\":0.121},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492344000,\"vol\":0.3},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492343100,\"vol\":0.5},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492340400,\"vol\":0.11},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492337700,\"vol\":0.025},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492335900,\"vol\":0.008},{\"closePrice\":7209.99,\"highPrice\":7209.99,\"lowPrice\":7209.99,\"openPrice\":7209.99,\"time\":1492335000,\"vol\":0.1},{\"closePrice\":7172.06,\"highPrice\":7181.0,\"lowPrice\":7172.06,\"openPrice\":7181.0,\"time\":1492328700,\"vol\":2.354},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492327800,\"vol\":0.18},{\"closePrice\":7180.0,\"highPrice\":7192.0,\"lowPrice\":7180.0,\"openPrice\":7192.0,\"time\":1492326900,\"vol\":0.577},{\"closePrice\":7192.0,\"highPrice\":7221.99,\"lowPrice\":7192.0,\"openPrice\":7210.0,\"time\":1492326000,\"vol\":2.001},{\"closePrice\":7203.0,\"highPrice\":7203.0,\"lowPrice\":7203.0,\"openPrice\":7203.0,\"time\":1492325100,\"vol\":1.959},{\"closePrice\":7203.0,\"highPrice\":7203.1,\"lowPrice\":7203.0,\"openPrice\":7203.1,\"time\":1492324200,\"vol\":0.011},{\"closePrice\":7203.0,\"highPrice\":7203.0,\"lowPrice\":7203.0,\"openPrice\":7203.0,\"time\":1492323300,\"vol\":0.914},{\"closePrice\":7202.0,\"highPrice\":7203.0,\"lowPrice\":7202.0,\"openPrice\":7203.0,\"time\":1492322400,\"vol\":0.213},{\"closePrice\":7213.0,\"highPrice\":7213.0,\"lowPrice\":7209.0,\"openPrice\":7209.0,\"time\":1492320600,\"vol\":1.355},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7198.0,\"openPrice\":7198.0,\"time\":1492319700,\"vol\":1.177},{\"closePrice\":7198.0,\"highPrice\":7198.0,\"lowPrice\":7198.0,\"openPrice\":7198.0,\"time\":1492318800,\"vol\":0.039},{\"closePrice\":7198.0,\"highPrice\":7198.0,\"lowPrice\":7198.0,\"openPrice\":7198.0,\"time\":1492317000,\"vol\":0.05},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492314300,\"vol\":0.03},{\"closePrice\":7209.0,\"highPrice\":7209.0,\"lowPrice\":7209.0,\"openPrice\":7209.0,\"time\":1492310700,\"vol\":0.02},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492309800,\"vol\":0.623},{\"closePrice\":7172.0,\"highPrice\":7180.0,\"lowPrice\":7172.0,\"openPrice\":7180.0,\"time\":1492306200,\"vol\":2.921},{\"closePrice\":7213.0,\"highPrice\":7213.0,\"lowPrice\":7172.0,\"openPrice\":7188.88,\"time\":1492305300,\"vol\":7.547},{\"closePrice\":7188.58,\"highPrice\":7213.0,\"lowPrice\":7188.58,\"openPrice\":7213.0,\"time\":1492304400,\"vol\":0.93},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492303500,\"vol\":2.293},{\"closePrice\":7190.0,\"highPrice\":7228.0,\"lowPrice\":7190.0,\"openPrice\":7228.0,\"time\":1492300800,\"vol\":1.001},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492299900,\"vol\":0.12},{\"closePrice\":7190.0,\"highPrice\":7192.01,\"lowPrice\":7190.0,\"openPrice\":7192.01,\"time\":1492298100,\"vol\":2.182},{\"closePrice\":7196.01,\"highPrice\":7196.01,\"lowPrice\":7196.01,\"openPrice\":7196.01,\"time\":1492297200,\"vol\":1.057},{\"closePrice\":7195.18,\"highPrice\":7195.19,\"lowPrice\":7195.18,\"openPrice\":7195.19,\"time\":1492295400,\"vol\":1.308},{\"closePrice\":7195.19,\"highPrice\":7213.0,\"lowPrice\":7195.19,\"openPrice\":7213.0,\"time\":1492294500,\"vol\":1.154},{\"closePrice\":7234.0,\"highPrice\":7234.0,\"lowPrice\":7234.0,\"openPrice\":7234.0,\"time\":1492292700,\"vol\":0.304},{\"closePrice\":7255.0,\"highPrice\":7255.01,\"lowPrice\":7255.0,\"openPrice\":7255.01,\"time\":1492290900,\"vol\":1.466},{\"closePrice\":7255.0,\"highPrice\":7255.0,\"lowPrice\":7255.0,\"openPrice\":7255.0,\"time\":1492281000,\"vol\":0.167},{\"closePrice\":7255.0,\"highPrice\":7275.97,\"lowPrice\":7255.0,\"openPrice\":7275.97,\"time\":1492280100,\"vol\":0.67},{\"closePrice\":7276.0,\"highPrice\":7276.01,\"lowPrice\":7276.0,\"openPrice\":7276.01,\"time\":1492278300,\"vol\":0.717},{\"closePrice\":7285.0,\"highPrice\":7285.0,\"lowPrice\":7285.0,\"openPrice\":7285.0,\"time\":1492277400,\"vol\":0.002},{\"closePrice\":7288.0,\"highPrice\":7288.0,\"lowPrice\":7288.0,\"openPrice\":7288.0,\"time\":1492275600,\"vol\":0.036},{\"closePrice\":7288.0,\"highPrice\":7288.0,\"lowPrice\":7277.0,\"openPrice\":7277.0,\"time\":1492273800,\"vol\":1.041},{\"closePrice\":7290.0,\"highPrice\":7290.0,\"lowPrice\":7260.5,\"openPrice\":7260.5,\"time\":1492272000,\"vol\":3.838},{\"closePrice\":7260.49,\"highPrice\":7260.49,\"lowPrice\":7260.49,\"openPrice\":7260.49,\"time\":1492271100,\"vol\":0.728},{\"closePrice\":7260.49,\"highPrice\":7260.49,\"lowPrice\":7214.44,\"openPrice\":7214.44,\"time\":1492270200,\"vol\":14.26},{\"closePrice\":7214.19,\"highPrice\":7248.0,\"lowPrice\":7213.16,\"openPrice\":7213.16,\"time\":1492269300,\"vol\":0.737},{\"closePrice\":7240.0,\"highPrice\":7240.0,\"lowPrice\":7212.99,\"openPrice\":7212.99,\"time\":1492268400,\"vol\":7.751},{\"closePrice\":7180.15,\"highPrice\":7180.15,\"lowPrice\":7180.15,\"openPrice\":7180.15,\"time\":1492267500,\"vol\":0.049},{\"closePrice\":7178.78,\"highPrice\":7178.78,\"lowPrice\":7178.78,\"openPrice\":7178.78,\"time\":1492266600,\"vol\":0.011},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7209.0,\"openPrice\":7209.0,\"time\":1492265700,\"vol\":1.933},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492264800,\"vol\":2.101},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492263900,\"vol\":0.157},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492263000,\"vol\":1.742},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7210.0,\"openPrice\":7210.0,\"time\":1492262100,\"vol\":1.475},{\"closePrice\":7210.0,\"highPrice\":7210.0,\"lowPrice\":7192.0,\"openPrice\":7192.0,\"time\":1492260300,\"vol\":2.922},{\"closePrice\":7192.0,\"highPrice\":7192.0,\"lowPrice\":7192.0,\"openPrice\":7192.0,\"time\":1492257600,\"vol\":0.017},{\"closePrice\":7192.0,\"highPrice\":7192.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492256700,\"vol\":0.332},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492255800,\"vol\":0.001},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492253100,\"vol\":0.013},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7187.0,\"openPrice\":7187.0,\"time\":1492252200,\"vol\":3.533},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492250400,\"vol\":0.016},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7179.9,\"openPrice\":7179.9,\"time\":1492249500,\"vol\":3.339},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492247700,\"vol\":0.25},{\"closePrice\":7150.0,\"highPrice\":7158.01,\"lowPrice\":7150.0,\"openPrice\":7158.01,\"time\":1492246800,\"vol\":6.167},{\"closePrice\":7184.0,\"highPrice\":7184.0,\"lowPrice\":7184.0,\"openPrice\":7184.0,\"time\":1492245900,\"vol\":0.185},{\"closePrice\":7187.0,\"highPrice\":7187.0,\"lowPrice\":7187.0,\"openPrice\":7187.0,\"time\":1492244100,\"vol\":0.433},{\"closePrice\":7157.0,\"highPrice\":7157.0,\"lowPrice\":7157.0,\"openPrice\":7157.0,\"time\":1492241400,\"vol\":2.443},{\"closePrice\":7157.0,\"highPrice\":7161.0,\"lowPrice\":7157.0,\"openPrice\":7161.0,\"time\":1492240500,\"vol\":2.803},{\"closePrice\":7188.0,\"highPrice\":7188.0,\"lowPrice\":7188.0,\"openPrice\":7188.0,\"time\":1492238700,\"vol\":0.102},{\"closePrice\":7188.0,\"highPrice\":7188.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492237800,\"vol\":0.298},{\"closePrice\":7161.0,\"highPrice\":7163.0,\"lowPrice\":7161.0,\"openPrice\":7163.0,\"time\":1492236900,\"vol\":0.042},{\"closePrice\":7163.0,\"highPrice\":7163.0,\"lowPrice\":7163.0,\"openPrice\":7163.0,\"time\":1492234200,\"vol\":0.851},{\"closePrice\":7163.0,\"highPrice\":7163.0,\"lowPrice\":7163.0,\"openPrice\":7163.0,\"time\":1492233300,\"vol\":0.056},{\"closePrice\":7163.0,\"highPrice\":7163.0,\"lowPrice\":7163.0,\"openPrice\":7163.0,\"time\":1492232400,\"vol\":0.052},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492231500,\"vol\":0.696},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7175.0,\"openPrice\":7175.0,\"time\":1492229700,\"vol\":0.806},{\"closePrice\":7160.0,\"highPrice\":7165.0,\"lowPrice\":7160.0,\"openPrice\":7165.0,\"time\":1492228800,\"vol\":0.02},{\"closePrice\":7160.0,\"highPrice\":7171.0,\"lowPrice\":7157.0,\"openPrice\":7171.0,\"time\":1492227900,\"vol\":1.701},{\"closePrice\":7175.0,\"highPrice\":7175.0,\"lowPrice\":7175.0,\"openPrice\":7175.0,\"time\":1492226100,\"vol\":0.069},{\"closePrice\":7180.0,\"highPrice\":7180.01,\"lowPrice\":7180.0,\"openPrice\":7180.01,\"time\":1492225200,\"vol\":0.071},{\"closePrice\":7188.0,\"highPrice\":7188.0,\"lowPrice\":7187.0,\"openPrice\":7187.0,\"time\":1492224300,\"vol\":0.013},{\"closePrice\":7180.01,\"highPrice\":7180.01,\"lowPrice\":7180.01,\"openPrice\":7180.01,\"time\":1492223400,\"vol\":1.152},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492222500,\"vol\":1.089},{\"closePrice\":7151.0,\"highPrice\":7151.0,\"lowPrice\":7151.0,\"openPrice\":7151.0,\"time\":1492219800,\"vol\":1.46},{\"closePrice\":7151.0,\"highPrice\":7170.0,\"lowPrice\":7151.0,\"openPrice\":7170.0,\"time\":1492218900,\"vol\":7.919},{\"closePrice\":7171.0,\"highPrice\":7171.0,\"lowPrice\":7171.0,\"openPrice\":7171.0,\"time\":1492218000,\"vol\":0.054},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492217100,\"vol\":0.004},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492216200,\"vol\":1.989},{\"closePrice\":7180.0,\"highPrice\":7180.0,\"lowPrice\":7180.0,\"openPrice\":7180.0,\"time\":1492214400,\"vol\":1.251},{\"closePrice\":7171.1,\"highPrice\":7171.2,\"lowPrice\":7171.1,\"openPrice\":7171.2,\"time\":1492213500,\"vol\":6.862},{\"closePrice\":7173.0,\"highPrice\":7173.0,\"lowPrice\":7173.0,\"openPrice\":7173.0,\"time\":1492212600,\"vol\":0.738},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492210800,\"vol\":0.008},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492209000,\"vol\":0.013},{\"closePrice\":7173.0,\"highPrice\":7178.0,\"lowPrice\":7173.0,\"openPrice\":7178.0,\"time\":1492206300,\"vol\":5.802},{\"closePrice\":7178.0,\"highPrice\":7178.0,\"lowPrice\":7178.0,\"openPrice\":7178.0,\"time\":1492205400,\"vol\":0.083},{\"closePrice\":7173.0,\"highPrice\":7173.0,\"lowPrice\":7173.0,\"openPrice\":7173.0,\"time\":1492198200,\"vol\":0.003},{\"closePrice\":7171.1,\"highPrice\":7211.98,\"lowPrice\":7171.1,\"openPrice\":7211.98,\"time\":1492186500,\"vol\":0.089},{\"closePrice\":7212.0,\"highPrice\":7212.0,\"lowPrice\":7189.99,\"openPrice\":7189.99,\"time\":1492183800,\"vol\":0.486},{\"closePrice\":7189.99,\"highPrice\":7189.99,\"lowPrice\":7189.99,\"openPrice\":7189.99,\"time\":1492182900,\"vol\":0.029},{\"closePrice\":7190.03,\"highPrice\":7190.03,\"lowPrice\":7152.0,\"openPrice\":7175.03,\"time\":1492182000,\"vol\":1.644},{\"closePrice\":7175.03,\"highPrice\":7192.0,\"lowPrice\":7175.03,\"openPrice\":7192.0,\"time\":1492181100,\"vol\":0.254},{\"closePrice\":7230.0,\"highPrice\":7230.0,\"lowPrice\":7175.0,\"openPrice\":7185.0,\"time\":1492180200,\"vol\":8.031},{\"closePrice\":7185.0,\"highPrice\":7200.0,\"lowPrice\":7185.0,\"openPrice\":7200.0,\"time\":1492179300,\"vol\":2.446},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7186.0,\"openPrice\":7186.0,\"time\":1492178400,\"vol\":3.231},{\"closePrice\":7186.0,\"highPrice\":7186.01,\"lowPrice\":7186.0,\"openPrice\":7186.01,\"time\":1492177500,\"vol\":4.955},{\"closePrice\":7186.0,\"highPrice\":7186.0,\"lowPrice\":7186.0,\"openPrice\":7186.0,\"time\":1492175700,\"vol\":0.03},{\"closePrice\":7186.0,\"highPrice\":7186.0,\"lowPrice\":7186.0,\"openPrice\":7186.0,\"time\":1492174800,\"vol\":5.215},{\"closePrice\":7187.0,\"highPrice\":7188.01,\"lowPrice\":7187.0,\"openPrice\":7188.01,\"time\":1492173900,\"vol\":5.848},{\"closePrice\":7192.0,\"highPrice\":7192.0,\"lowPrice\":7192.0,\"openPrice\":7192.0,\"time\":1492171200,\"vol\":0.554},{\"closePrice\":7224.0,\"highPrice\":7224.0,\"lowPrice\":7214.0,\"openPrice\":7214.0,\"time\":1492167600,\"vol\":3.501},{\"closePrice\":7214.0,\"highPrice\":7214.0,\"lowPrice\":7214.0,\"openPrice\":7214.0,\"time\":1492166700,\"vol\":0.026},{\"closePrice\":7200.0,\"highPrice\":7200.0,\"lowPrice\":7200.0,\"openPrice\":7200.0,\"time\":1492165800,\"vol\":2.144},{\"closePrice\":7214.0,\"highPrice\":7214.0,\"lowPrice\":7211.2,\"openPrice\":7211.2,\"time\":1492164000,\"vol\":1.201},{\"closePrice\":7211.2,\"highPrice\":7211.2,\"lowPrice\":7211.2,\"openPrice\":7211.2,\"time\":1492163100,\"vol\":0.001},{\"closePrice\":7211.2,\"highPrice\":7211.2,\"lowPrice\":7190.0,\"openPrice\":7190.0,\"time\":1492161300,\"vol\":0.052},{\"closePrice\":7190.0,\"highPrice\":7190.0,\"lowPrice\":7188.0,\"openPrice\":7188.0,\"time\":1492159500,\"vol\":0.663},{\"closePrice\":7188.0,\"highPrice\":7213.0,\"lowPrice\":7188.0,\"openPrice\":7213.0,\"time\":1492158600,\"vol\":5.5},{\"closePrice\":7213.0,\"highPrice\":7214.0,\"lowPrice\":7213.0,\"openPrice\":7213.1,\"time\":1492157700,\"vol\":16.698},{\"closePrice\":7238.0,\"highPrice\":7238.0,\"lowPrice\":7213.0,\"openPrice\":7213.0,\"time\":1492156800,\"vol\":1.868},{\"closePrice\":7238.0,\"highPrice\":7238.0,\"lowPrice\":7213.0,\"openPrice\":7213.2,\"time\":1492155900,\"vol\":7.563},{\"closePrice\":7239.9,\"highPrice\":7239.9,\"lowPrice\":7234.0,\"openPrice\":7234.0,\"time\":1492155000,\"vol\":0.988},{\"closePrice\":7234.0,\"highPrice\":7235.0,\"lowPrice\":7213.1,\"openPrice\":7235.0,\"time\":1492154100,\"vol\":1.678},{\"closePrice\":7214.0,\"highPrice\":7214.0,\"lowPrice\":7213.1,\"openPrice\":7213.5,\"time\":1492153200,\"vol\":0.832},{\"closePrice\":7215.0,\"highPrice\":7219.0,\"lowPrice\":7215.0,\"openPrice\":7219.0,\"time\":1492152300,\"vol\":2.771}]";

// ////////////默认值////////////////
    /** 默认背景色 */
    public static final int DEFAULT_BACKGROUD = 0x090A0B;

    /** 默认字体大小 **/
    public float DEFAULT_AXIS_TITLE_SIZE =10;


    /** 默认字体颜色 **/
    public static  int DEFAULT_AXIS_TITLE_COLOR = 0x78797A;
    /** 默认点击xy选择框颜色 **/
    public static int DEFAULT_AXIS_XYCLICK_COLOR = 0x535d66;

    /** 默认XY坐标轴颜色 */
    private static int DEFAULT_AXIS_COLOR = Color.RED;

    /** 默认经纬线颜色 */
    private static int DEFAULT_LONGI_LAITUDE_COLOR = 0x3b3b3d;

    private static int DEFAULT_TIP_BACKGROUND_COLOR = 0x6fc6e9;
    private static int DEFAULT_TIP_BACKGROUND_TEXT_COLOR = 0x408ff2;

    /** 默认上表纬线数 */
    public static final int DEFAULT_UPER_LATITUDE_NUM = 4;
    /** 默认中表纬线数 */
    private static final int DEFAULT_MIDDLE_LATITUDE_NUM = 2;
    /** 默认下表纬线数 */
    public static  int DEFAULT_LOWER_LATITUDE_NUM = 2;

    /** 当前被选中touch点 */
    private PointF touchPoint = null;

    /** 选中位置X坐标 */
    private float clickPostX = 0f;

    /** 选中位置Y坐标*/
    private float clickPostY = 0f;

    /** 点击时横轴X刻度*/
    private String axisXTitleClick="";

    /** 点击时横轴Y刻度*/
    private String axisYTitleClick="";


    /** 横轴X刻度*/
    private List<String> axisXTitles;
    /** 纵轴Y刻度*/
    private List<String> axisYTitles;


    /** 默认Y轴刻度显示长度 */
    private int DEFAULT_AXIS_Y_MAX_TITLE_LENGTH = 7;

    /** 默认经线数 */
    public static final int DEFAULT_LOGITUDE_NUM = 8;

    /** 默认边框的颜色 */
    public static final int DEFAULT_BORDER_COLOR = Color.RED;

    /** 默认虚线效果 */
    private static final PathEffect DEFAULT_DASH_EFFECT = new DashPathEffect(
            new float[] { 15, 15, 15, 15 }, 15);


    /** 上表的上间隙 */
    public static float UPER_CHART_MARGIN_TOP;

    /** 上表的顶部 */
    public static float UPER_CHART_TOP;
    /** 上表的下间隙 */
    public static float UPER_CHART_MARGIN_BOTTOM;

    /** 中表的顶部 */
    public static float MIDDLE_CHART_TOP;

    /** 下表的顶部 */
    public static float LOWER_CHART_TOP;

    /** 所有表的title高 */
    public float TITLE_HEIGHT = DEFAULT_AXIS_TITLE_SIZE+2;

    /** 图表跟右边距离 */
    public float DEFAULT_AXIS_MARGIN_RIGHT = DEFAULT_AXIS_TITLE_SIZE*2;

    // /////////////属性////////////////
    /** 背景色 */
    private int mBackGround;

    /** 坐标轴XY颜色 */
    private int mAxisColor;

    /** 经纬线颜色 */
    private int mLongiLatitudeColor;

    /** 虚线效果 */
    private PathEffect mDashEffect;

    /** 边线色 */
    private int mBorderColor;

    /** 上表高度 */
    public float mUperChartHeight;
    /** 中表高度 */
    public float mMiddleChartHeight;
    /** 下表高度 */
    public float mLowerChartHeight;

    /** 下表TabIndex */
    private int mTabIndex;

    //经线间隔度
    private float longitudeSpacing;
    //维线间隔度
    private float latitudeSpacing;
    private Context mContext;


    public MyGridChartView(Context context) {
        super(context);
        initBaseData(context);
    }

    public MyGridChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBaseData(context);
    }

    public MyGridChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBaseData(context);
    }

    /**
     * 初始化一些数值
     * @param context
     */
    private void initBaseData(Context context) {
        mContext = context;
        mBackGround = context.getResources().getColor(R.color.klinebg);
        DEFAULT_AXIS_TITLE_COLOR = context.getResources().getColor(R.color.kViewztblack);
        DEFAULT_LONGI_LAITUDE_COLOR = context.getResources().getColor(R.color.kViewjwblack);
        DEFAULT_AXIS_XYCLICK_COLOR= context.getResources().getColor(R.color.kViewclickblack);
        DEFAULT_AXIS_COLOR = DEFAULT_AXIS_TITLE_COLOR;
        mAxisColor = DEFAULT_AXIS_COLOR;
        //mLongiLatitudeColor = DEFAULT_LONGI_LAITUDE_COLOR;
        mLongiLatitudeColor = Color.RED;
        initSize();
        mDashEffect = DEFAULT_DASH_EFFECT;
        mBorderColor = Color.RED;
        mTabIndex = 0;
    }

    public void initSize()
    {
        DEFAULT_AXIS_TITLE_SIZE = sp2px(mContext,DEFAULT_AXIS_TITLE_SIZE);
        TITLE_HEIGHT = DEFAULT_AXIS_TITLE_SIZE+sp2px(mContext,2);
        DEFAULT_AXIS_MARGIN_RIGHT =  sp2px(mContext,40);

    }

    /**
     * 重新控件大�?
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setBackgroundColor(mBackGround);

        int viewHeight = getHeight();
        int viewWidth = getWidth();

        //经度(竖线) (间隔距离）
        longitudeSpacing = (viewWidth - DEFAULT_AXIS_MARGIN_RIGHT-2)/DEFAULT_LOGITUDE_NUM;
        //维度#####4-8 (间隔距离）
        //latitudeSpacing =(viewHeight - TITLE_HEIGHT*9)/(DEFAULT_UPER_LATITUDE_NUM+DEFAULT_LOWER_LATITUDE_NUM+DEFAULT_MIDDLE_LATITUDE_NUM);
        latitudeSpacing =(viewHeight - TITLE_HEIGHT*9)/(DEFAULT_UPER_LATITUDE_NUM);

        // 上、中、下表距离
        mUperChartHeight = DEFAULT_UPER_LATITUDE_NUM*latitudeSpacing;
        mMiddleChartHeight = DEFAULT_MIDDLE_LATITUDE_NUM*latitudeSpacing;
        mLowerChartHeight = DEFAULT_LOWER_LATITUDE_NUM*latitudeSpacing;


        UPER_CHART_MARGIN_TOP = 3*TITLE_HEIGHT;
        //###加上表间隔
        UPER_CHART_TOP = TITLE_HEIGHT+UPER_CHART_MARGIN_TOP;
        UPER_CHART_MARGIN_BOTTOM = 2*TITLE_HEIGHT;

        MIDDLE_CHART_TOP = 3*TITLE_HEIGHT+mUperChartHeight+UPER_CHART_MARGIN_BOTTOM+UPER_CHART_MARGIN_TOP;
        LOWER_CHART_TOP =MIDDLE_CHART_TOP+mMiddleChartHeight+TITLE_HEIGHT;

        // 绘制边框
        drawBorders(canvas, viewHeight, viewWidth);

        // 绘制纬线
        drawLatitudes(canvas, viewWidth, latitudeSpacing);
        // 绘制经线
        drawLongitudes(canvas,longitudeSpacing);

    }



    /**
     * 绘制经线
     *
     * @param canvas
     */
    private void drawLongitudes(Canvas canvas, float longitudeSpacing)  {
        if(axisXTitles==null)
            return;
        Paint paint = new Paint();
        paint.setColor(mLongiLatitudeColor);
        paint.setPathEffect(mDashEffect);
        paint.setTextSize(DEFAULT_AXIS_TITLE_SIZE);


        Paint paintAxis = new Paint();
        paintAxis.setColor(mAxisColor);
        paintAxis.setTextSize(DEFAULT_AXIS_TITLE_SIZE);

        for (int i = 0; i < axisXTitles.size(); i++) {
            float tWidth = paint.measureText(axisXTitles.get(i));
            // 绘制刻度
            canvas.drawText(axisXTitles.get(i), super.getWidth()-DEFAULT_AXIS_MARGIN_RIGHT-longitudeSpacing * (i)-tWidth, TITLE_HEIGHT + mUperChartHeight +UPER_CHART_MARGIN_BOTTOM+UPER_CHART_MARGIN_TOP+DEFAULT_AXIS_TITLE_SIZE, paintAxis);

        }
    }



    /**
     * 绘制纬线
     *
     * @param canvas
     * @param viewWidth
     */
    private void drawLatitudes(Canvas canvas, int viewWidth, float latitudeSpacing) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setPathEffect(mDashEffect);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setTextSize(DEFAULT_AXIS_TITLE_SIZE);

        Paint paintAxis = new Paint();
        paintAxis.setColor(Color.RED);
        paintAxis.setTextSize(DEFAULT_AXIS_TITLE_SIZE);

        Path path = new Path();
        path.moveTo(0, UPER_CHART_TOP);
        path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,UPER_CHART_TOP);   //第二条
        canvas.drawPath(path, paint);


        path.moveTo(0, TITLE_HEIGHT);
        path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,TITLE_HEIGHT);  // 最上面一条虚线
        canvas.drawPath(path, paint);

        path.moveTo(0, MIDDLE_CHART_TOP-2*TITLE_HEIGHT-UPER_CHART_MARGIN_BOTTOM);
        path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,MIDDLE_CHART_TOP-2*TITLE_HEIGHT-UPER_CHART_MARGIN_BOTTOM); // 最底下第二个个虚线
        canvas.drawPath(path, paint);

        path.moveTo(0, MIDDLE_CHART_TOP-TITLE_HEIGHT);
        path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,MIDDLE_CHART_TOP-TITLE_HEIGHT);  // 最底下一个虚线
        canvas.drawPath(path, paint);

        path.moveTo(0, MIDDLE_CHART_TOP-2*TITLE_HEIGHT);
        path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,MIDDLE_CHART_TOP-2*TITLE_HEIGHT);
        canvas.drawPath(path, paint);

        path.moveTo(0, LOWER_CHART_TOP-TITLE_HEIGHT);
        path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,LOWER_CHART_TOP-TITLE_HEIGHT);
        canvas.drawPath(path, paint);   // 控制最高最低，横坐标的横线。  // 为啥现在画看不到效果


        //刻度颜色
        paint.setColor(mLongiLatitudeColor);
        for (int i = 0; i <DEFAULT_UPER_LATITUDE_NUM; i++) {
            //线

            path.moveTo(0, UPER_CHART_TOP+latitudeSpacing * (i+1));
            path.lineTo(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,UPER_CHART_TOP  + latitudeSpacing * (i+1));
            // canvas.drawPath(path, paint);

            if(axisYTitles!=null)
            {
                // 绘制Y刻度
                canvas.drawText(axisYTitles.get(i), viewWidth-DEFAULT_AXIS_MARGIN_RIGHT, MIDDLE_CHART_TOP-2*TITLE_HEIGHT-UPER_CHART_MARGIN_BOTTOM-latitudeSpacing*(i), paintAxis);
                if(i==DEFAULT_UPER_LATITUDE_NUM-1)
                {
                    canvas.drawText(axisYTitles.get(DEFAULT_UPER_LATITUDE_NUM), viewWidth-DEFAULT_AXIS_MARGIN_RIGHT, MIDDLE_CHART_TOP-2*TITLE_HEIGHT-UPER_CHART_MARGIN_BOTTOM-latitudeSpacing*(DEFAULT_UPER_LATITUDE_NUM), paintAxis);

                }
            }

        }

    }


    /**
     * 绘制边框   以屏幕左上角作为起始值（0,0），向下为正值
     *
     * @param canvas
     */
    private void drawBorders(Canvas canvas, int viewHeight, int viewWidth) {
        Paint paint = new Paint();
        paint.setColor(mBorderColor);
        paint.setStrokeWidth(1);
        canvas.drawLine(0, 0, 0,viewHeight, paint);  // 最左侧的竖线
        canvas.drawLine(0, 0, viewWidth,0, paint);  // 最上面的竖线
        canvas.drawLine(viewWidth-1, 0, viewWidth-1,viewHeight-1, paint);  // 最右侧的竖线
        canvas.drawLine(0,viewHeight-1, viewWidth-1,viewHeight-1, paint);
        canvas.drawLine(viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,0, viewWidth-DEFAULT_AXIS_MARGIN_RIGHT,viewHeight, paint);
    }





    /**
     * 单点击事件
     */
    protected void drawWithFingerClick(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimary));   // 上次为什么识别不了放在其它目录的颜色值
        paint.setStrokeWidth(2);

        float lineVlenth = getHeight() - 2f;       // 为啥钟爱 float类型的数据


        float startX = touchPoint.x > super.getWidth() - DEFAULT_AXIS_MARGIN_RIGHT ? super.getWidth() -DEFAULT_AXIS_MARGIN_RIGHT:touchPoint.x;
        float StopX = touchPoint.x > super.getWidth() - DEFAULT_AXIS_MARGIN_RIGHT ? super.getWidth() - DEFAULT_AXIS_MARGIN_RIGHT : touchPoint.x;
        canvas.drawLine(startX,1f,StopX,lineVlenth,paint);
    }


    private float spacing(MotionEvent event) {
        float x_distance = event.getX(0) - event.getX(1);
        float y_distance = event.getY(0) - event.getY(1);

        return (float) Math.sqrt(x_distance * x_distance + y_distance * y_distance);
    }



    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
        return result;
    }


    public float sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return  (spValue * fontScale + 0.5f);
    }
}
