package com.tutorials.myapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 2 // Default and the first question position
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0

    private var progressBar:ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)

        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)

        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {

        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()
        /* if we are at the last question then change the text of btn submit to Finish*/
        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }

        ivImage?.setImageResource(question.image)

        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0, it)
        }
        tvOptionTwo?.let{
            options.add(1, it)
        }
        tvOptionThree?.let{
            options.add(2, it)
        }
        tvOptionFour?.let{
            options.add(3, it)
        }
        for(option in options){
            /* set text color of default options */
            option.setTextColor(Color.parseColor("#7A8089"))
            /* selected option is shown default after you selected it once */
            option.typeface = Typeface.DEFAULT
            /* change the border to default color after selection */
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )

        }
    }

    private fun selectedOptionsView(tv:TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        /* selected option is shown bold */
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        /* change the selected border to selected color background after selection */
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            /* on clicking text view options, send the textViewItem via It, and
                selectedOptionNum argument as 1,2,3,4 depending on number of options
            */
            R.id.tv_option_one -> {
                tvOptionOne?.let{
                    selectedOptionsView(it, 1)
                }
            }
            R.id.tv_option_two -> {
                tvOptionTwo?.let{
                    selectedOptionsView(it, 2)
                }
            }
            R.id.tv_option_three -> {
                tvOptionThree?.let{
                    selectedOptionsView(it, 3)
                }
            }
            R.id.tv_option_four -> {
                tvOptionFour?.let{
                    selectedOptionsView(it, 4)
                }
            }

            R.id.btn_submit -> {
                /*TODO*/
            }
        }
    }
}