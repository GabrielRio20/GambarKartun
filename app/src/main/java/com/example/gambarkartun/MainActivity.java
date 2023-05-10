package com.example.gambarkartun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas canvas;
    private Paint paint = new Paint();
    private Paint paintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);

    private Paint paintCircle = new Paint();
    private Bitmap bitmap;
    private ImageView imageView;

    private Rect rect = new Rect();
    private Rect bounds = new Rect();
    private static final int OFFSET = 120;
    private int offset = OFFSET;
    private static final int MULTIPLIER = 100;

    private int colorHair;
    private int colorRectangle;
    private int colorFace;
    private  int colorBody;
    private  int colorRearFoot;
    private int colorText;
    private int colorWhite;
    private int colorBlue;
    private int colorBg;
    private int colorBg2;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorHair = ResourcesCompat.getColor(getResources(), R.color.colorHair, null);
        colorRectangle = ResourcesCompat.getColor(getResources(), R.color.colorRectangle, null);
        colorFace = ResourcesCompat.getColor(getResources(), R.color.colorFace, null);
        colorBody = ResourcesCompat.getColor(getResources(), R.color.colorBody, null);
        colorRearFoot = ResourcesCompat.getColor(getResources(), R.color.colorRearFoot, null);
        colorText = ResourcesCompat.getColor(getResources(), R.color.black, null);
        colorWhite = ResourcesCompat.getColor(getResources(), R.color.white, null);
        colorBlue = ResourcesCompat.getColor(getResources(), R.color.colorBlue, null);
        colorBg = ResourcesCompat.getColor(getResources(), R.color.colorBg, null);
        colorBg2 = ResourcesCompat.getColor(getResources(), R.color.colorBg2, null);

        paint.setColor(colorHair);
        paintText.setColor(colorText);
        paintText.setTextSize(70);

        imageView = findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawSomething(v, count);
                count += 1;
            }
        });
    }

    public void drawSomething(View v, int count){
        int width = v.getWidth();
        int height = v.getHeight();
        int halfWidth = v.getWidth()/2;
        int halfHeight = v.getHeight()/2;
        float radius = (float) (Math.min(width/6, height/6));

        if(count == 0) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            imageView.setImageBitmap(bitmap);
            canvas = new Canvas(bitmap);
        }

        else if(count == 1){
            //background sky
            paint.setColor(colorBg);
            Point k = new Point(halfWidth-1000, halfHeight-1000);
            Point l = new Point(halfWidth+1000, halfHeight-1000);
            Point m = new Point(halfWidth+1000, halfHeight+1000);
            Point n = new Point(halfWidth-1000, halfHeight+1000);

            Path bg = new Path();
            bg.setFillType(Path.FillType.EVEN_ODD);
            bg.lineTo(k.x, k.y);
            bg.lineTo(l.x, l.y);
            bg.lineTo(m.x, m.y);
            bg.lineTo(n.x, n.y);
            bg.lineTo(k.x, k.y);
            bg.close();

            canvas.drawPath(bg, paint);
        }

        else if(count == 2) {
            //background ground
            paint.setColor(colorBg2);
            Point o = new Point(halfWidth - 1000, halfHeight + 400);
            Point p = new Point(halfWidth + 1000, halfHeight + 400);
            Point q = new Point(halfWidth + 1000, halfHeight + 1000);
            Point r = new Point(halfWidth - 1000, halfHeight + 1000);

            Path bg2 = new Path();
            bg2.setFillType(Path.FillType.EVEN_ODD);
            bg2.lineTo(o.x, o.y);
            bg2.lineTo(p.x, p.y);
            bg2.lineTo(q.x, q.y);
            bg2.lineTo(r.x, r.y);
            bg2.lineTo(o.x, o.y);
            bg2.close();

            canvas.drawPath(bg2, paint);
        }

        else if(count == 3) {
            //left rear foot
            paint.setColor(colorRearFoot);
            RectF rect3 = new RectF(halfWidth-160, halfHeight+600, halfWidth-10, halfHeight+880);
            canvas.drawOval(rect3, paint);
        }

        else if (count == 4) {
            //right rear foot
            paint.setColor(colorRearFoot);
            RectF rect4 = new RectF(halfWidth+160, halfHeight+600, halfWidth+10, halfHeight+880);
            canvas.drawOval(rect4, paint);
        }

        else if(count == 5) {
            //body
            paint.setColor(colorBody);
            canvas.drawCircle(halfWidth, halfHeight+500, halfHeight / (7/2), paint);
        }

        else if(count == 6) {
            //left front foot
            paint.setColor(colorFace);
            RectF rect1 = new RectF(halfWidth-250, halfHeight+650, halfWidth-100, halfHeight+900);
            canvas.drawOval(rect1, paint);
        }

        else if(count == 7) {
            //right front foot
            paint.setColor(colorFace);
            RectF rect2 = new RectF(halfWidth+250, halfHeight+650, halfWidth+100, halfHeight+900);
            canvas.drawOval(rect2, paint);
        }

        else if(count == 8) {
            //dogtag
            paint.setColor(colorBlue);
            canvas.drawCircle(halfWidth, halfHeight+200, halfHeight/5, paint);

            paint.setColor(colorText);
            Point g = new Point(halfWidth-30, halfHeight+410);
            Point h = new Point(halfWidth, halfHeight+360);
            Point i = new Point(halfWidth+30, halfHeight+410);
            Point j = new Point(halfWidth, halfHeight+450);

            Path tag = new Path();
            tag.setFillType(Path.FillType.EVEN_ODD);
            tag.lineTo(g.x, g.y);
            tag.lineTo(h.x, h.y);
            tag.lineTo(i.x, i.y);
            tag.lineTo(j.x, j.y);
            tag.lineTo(g.x, g.y);
            tag.close();

            canvas.drawPath(tag, paint);
        }

        else if(count == 9) {
            //face rect
            paint.setColor(colorFace);
//            rect.set(2*offset, 5*offset, width-2*offset, height-8*offset);
//            canvas.drawRect(rect, paint);

            //face circle
            paint.setColor(colorFace);
            canvas.drawCircle(halfWidth, halfHeight-100, halfHeight/3, paint);
            canvas.drawCircle(halfWidth, halfHeight, halfHeight / (7/2), paint);
            int x = halfWidth - bounds.centerX();
            int y = halfHeight - bounds.centerY();
        }

        else if(count == 10) {
            //left ear
            paint.setColor(colorHair - MULTIPLIER * offset);
            Point a = new Point(halfWidth-410, halfHeight-310);
            Point b = new Point(halfWidth-150, halfHeight-398);
            Point c = new Point(halfWidth-330, halfHeight+50);

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.lineTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(a.x, a.y);
            path.close();

            canvas.drawPath(path, paint);


//            Paint border = new Paint();
//            border.setStyle(Paint.Style.STROKE);
//
//            Path borderPath = new Path();
//            borderPath.reset();
//            borderPath.moveTo(a.x, a.y);
//            borderPath.lineTo(b.x, b.y);
//            borderPath.lineTo(c.x, c.y);
//            borderPath.lineTo(a.x, a.y);
//            borderPath.close();
//
//            canvas.drawPath(borderPath, border);
        }

        else if(count == 11) {
            //right ear
            paint.setColor(colorHair - MULTIPLIER * offset);
            Point d = new Point(halfWidth + 410, halfHeight - 310);
            Point e = new Point(halfWidth + 150, halfHeight - 398);
            Point f = new Point(halfWidth + 330, halfHeight + 50);

//            Point d = new Point(halfWidth+400, halfHeight-350);
//            Point e = new Point(halfWidth+180, halfHeight-450);
//            Point f = new Point(halfWidth+300, halfHeight+50);

            Path path2 = new Path();
            path2.setFillType(Path.FillType.EVEN_ODD);
            path2.lineTo(d.x, d.y);
            path2.lineTo(e.x, e.y);
            path2.lineTo(f.x, f.y);
            path2.lineTo(d.x, d.y);
            path2.close();

            canvas.drawPath(path2, paint);
        }

        else if(count == 12) {
            //mouth
            paint.setColor(colorText);
            canvas.drawCircle(halfWidth, halfHeight+150, halfHeight/12, paint);
            paint.setColor(colorFace);
            canvas.drawCircle(halfWidth, halfHeight+110, halfHeight/12, paint);
        }

        else if(count == 13) {
            //nose
            paint.setColor(colorText);
            canvas.drawCircle(halfWidth, halfHeight, halfHeight/13, paint);
        }

        else {
            //eyes white
            paint.setColor(colorWhite);
            canvas.drawCircle(halfWidth-120, halfHeight-200, halfHeight/16, paint);
            paint.setColor(colorWhite);
            canvas.drawCircle(halfWidth+120, halfHeight-200, halfHeight/16, paint);

            //eyes black
            paint.setColor(colorText);
            canvas.drawCircle(halfWidth-120, halfHeight-200, halfHeight/23, paint);
            paint.setColor(colorText);
            canvas.drawCircle(halfWidth+120, halfHeight-200, halfHeight/23, paint);
        }

        v.invalidate();
    }
}
